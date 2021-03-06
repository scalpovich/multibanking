package de.adorsys.multibanking.hbci;

import de.adorsys.multibanking.domain.response.CreateConsentResponse;
import de.adorsys.multibanking.domain.response.UpdateAuthResponse;
import de.adorsys.multibanking.hbci.model.HbciConsent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
interface HbciScaMapper {

    @Mapping(target = "consentId", expression = "java( java.util.UUID.randomUUID().toString() )")
    @Mapping(target = "authorisationId", expression = "java( java.util.UUID.randomUUID().toString() )")
    @Mapping(target = "bankApiConsentData", expression = "java( bankApiConsentData )")
    @Mapping(target = "redirectUrl", ignore = true)
    @Mapping(target = "redirectId", ignore = true)
    @Mapping(target = "oauthRedirectUrl", ignore = true)
    @Mapping(target = "authorisationCodeResponse", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "scaApproach", constant = "EMBEDDED")
    CreateConsentResponse toCreateConsentResponse(HbciConsent bankApiConsentData);

    @Mapping(target = "challenge", ignore = true)
    @Mapping(target = "authorisationCodeResponse", ignore = true)
    @Mapping(target = "messages", ignore = true)
    @Mapping(target = "scaMethods", source = "hbciConsent.tanMethodList")
    @Mapping(target = "bankApiConsentData", source = "hbciConsent", resultType = Object.class)
    UpdateAuthResponse toUpdateAuthResponse(HbciConsent hbciConsent,
                                            @MappingTarget UpdateAuthResponse updateAuthResponse);

}
