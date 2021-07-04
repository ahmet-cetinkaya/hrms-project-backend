package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmailActivation;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmailActivationForVerifyDto;

public interface EmailActivationService extends BaseService<EmailActivation, Integer> {
	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
