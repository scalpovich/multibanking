package de.adorsys.multibanking.service;

import de.adorsys.multibanking.domain.BankAccessEntity;
import de.adorsys.multibanking.domain.ChallengeData;
import de.adorsys.multibanking.domain.ConsentEntity;
import de.adorsys.multibanking.domain.exception.MultibankingException;
import de.adorsys.multibanking.domain.response.UpdateAuthResponse;
import de.adorsys.multibanking.exception.InvalidConsentException;
import de.adorsys.multibanking.exception.InvalidPinException;
import de.adorsys.multibanking.exception.MissingConsentAuthorisationException;
import de.adorsys.multibanking.pers.spi.repository.BankAccessRepositoryIf;
import org.springframework.beans.factory.annotation.Autowired;

import static de.adorsys.multibanking.domain.exception.MultibankingError.*;

abstract class AccountInformationService {

    @Autowired
    private BankAccessRepositoryIf bankAccessRepository;

    RuntimeException handleMultibankingException(BankAccessEntity bankAccess, ConsentEntity consentEntity,
                                                           MultibankingException e) {
        if (e.getMultibankingError() == HBCI_2FA_REQUIRED) {
            // FIXME get the challenge data
            ChallengeData challengeData = null;
            UpdateAuthResponse response = new UpdateAuthResponse();
            response.setChallenge(challengeData);
            response.setPsuMessage(e.getMessage());
            return new MissingConsentAuthorisationException(response, consentEntity.getId(),
                consentEntity.getAuthorisationId());
        } else if (e.getMultibankingError() == INVALID_PIN) {
            return new InvalidPinException(bankAccess.getId());
        } else if (e.getMultibankingError() == INVALID_CONSENT) {
            bankAccess.setConsentId(null);
            bankAccessRepository.save(bankAccess);
            return new InvalidConsentException();
        }
        return e;
    }

}