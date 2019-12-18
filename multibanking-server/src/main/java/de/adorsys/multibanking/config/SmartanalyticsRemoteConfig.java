package de.adorsys.multibanking.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.adorsys.multibanking.exception.SmartanalyticsException;
import de.adorsys.multibanking.exception.domain.Message;
import de.adorsys.multibanking.exception.domain.Messages;
import de.adorsys.multibanking.logging.LoggingUtils;
import de.adorsys.sts.tokenauth.BearerToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;

@Slf4j
@Configuration
@Profile("smartanalytics-remote")
public class SmartanalyticsRemoteConfig {

    @Value("${SMARTANALYTICS_URL:http://localhost:8082}")
    private String smartanalyticsUrl;

    @Bean
    @Qualifier("smartanalytics")
    public RestTemplate restTemplate() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new Jackson2HalModule());
        mapper.registerModule(new JavaTimeModule());

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json, application/json"));
        converter.setObjectMapper(mapper);

        final RestTemplate restTemplate =
            new RestTemplate(new BufferingClientHttpRequestFactory(new AuthorizationClientRequestFactory()));
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(smartanalyticsUrl));
        restTemplate.setErrorHandler(new ErrorHandler());
        restTemplate.setMessageConverters(Collections.singletonList(converter));
        restTemplate.getInterceptors().add(new LoggingInterceptor("SMARTANALYTICS"));
        return restTemplate;
    }

    private static class ErrorHandler extends DefaultResponseErrorHandler {

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            String responseBody = new String(getResponseBody(response), getCharsetOrDefault(response));
            Message errorMessage = getErrorMessages(responseBody);
            if (errorMessage != null) {
                throw new SmartanalyticsException(response.getStatusCode(), errorMessage);
            }

            super.handleError(response);
        }

        private Charset getCharsetOrDefault(ClientHttpResponse response) {
            Charset charset = getCharset(response);
            return charset != null ? charset : StandardCharsets.UTF_8;
        }

        private Message getErrorMessages(String responseBody) {
            try {
                Collection<Message> messages = new ObjectMapper().readValue(responseBody, Messages.class).getMessages();
                if (!messages.isEmpty()) {
                    return messages.iterator().next();
                }
            } catch (IOException e) {
                //ignore
            }
            return null;
        }
    }

    private static class LoggingInterceptor implements ClientHttpRequestInterceptor {

        private String backend;

        LoggingInterceptor(String backend) {
            this.backend = backend;
        }

        @Override
        public @NonNull
        ClientHttpResponse intercept(HttpRequest request, @NonNull byte[] body,
                                     @NonNull ClientHttpRequestExecution execution) throws IOException {

            URI uri = request.getURI();

            String query = "";

            if (uri.getQuery() != null) {
                query = "?" + uri.getQuery() + " ";
            }

            Charset charset = LoggingUtils.determineCharset(request.getHeaders().getContentType());
            String requestString = LoggingUtils.cleanAndReduce(body, charset);

            log.trace("{} > {} {}{} {}", backend, request.getMethod(), request.getURI().getPath(), query,
                requestString);

            ClientHttpResponse response = execution.execute(request, body);

            String responseString = LoggingUtils.cleanAndReduce(IOUtils.toByteArray(response.getBody()), charset);

            log.trace("{} < {} {}", backend, response.getStatusCode(), responseString);

            return response;
        }
    }

    private static class AuthorizationClientRequestFactory extends HttpComponentsClientHttpRequestFactory implements ClientHttpRequestFactory {

        private static final String AUTHORIZATION_HEADER = "Authorization";

        @Autowired
        private BearerToken bearerToken;

        public AuthorizationClientRequestFactory() {
            super(HttpClients.custom()
                .disableCookieManagement()
                .build()
            );
        }

        @Override
        protected void postProcessHttpRequest(HttpUriRequest request) {
            request.setHeader(AUTHORIZATION_HEADER, bearerToken.getToken());
        }
    }
}
