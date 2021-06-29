package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmailActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.email.EmailService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.EmailActivationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmailActivation;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmailActivationForVerifyDto;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailActivationManager extends BaseManager<EmailActivationDao, EmailActivation, Integer> implements EmailActivationService {
    private final EmailActivationDao emailActivationDao;
    private final EmailService emailService;

    @Autowired
    public EmailActivationManager(final EmailActivationDao emailActivationDao, final EmailService emailService) {
        super(emailActivationDao, "Email activation");
        this.emailActivationDao = emailActivationDao;
        this.emailService = emailService;
    }

    @Override
    public Result createAndSendActivationCodeByMail(final User user, final String... emails) {

        for (final String email : emails) {
            final EmailActivation emailActivation = EmailActivation.builder()
                    .user(user)
                    .email(email)
                    .activationCode("EmailActivationCodeTEST") // TODO create activationCode
                    .expirationDate(LocalDateTime.now().plusMonths(1))
                    .build();
            super.add(emailActivation);
            emailService.send(email,
                    Messages.emailActivationVerifyEmailTitle,
                    String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
                            Messages.emailActivationVerifyEmailBody,
                            emailActivation.getActivationCode(),
                            email));
        }

        return new SuccessResult(Messages.emailActivationCreatedAndSent);
    }

    @Override
    public Result verify(final EmailActivationForVerifyDto emailActivationForVerifyDto) {
        final Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
                emailActivationForVerifyDto.getEmail(),
                emailActivationForVerifyDto.getActivationCode());

        if (emailActivation.isEmpty())
            return new ErrorResult(Messages.emailNotVerified);

        emailActivation.get().setActivated(true);
        emailActivationDao.save(emailActivation.get());

        return new SuccessResult(Messages.emailVerified);
    }

}
