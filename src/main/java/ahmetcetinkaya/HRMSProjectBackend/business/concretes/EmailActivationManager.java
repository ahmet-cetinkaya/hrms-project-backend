package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmailActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.email.EmailService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.EmailActivationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmailActivation;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmailActivationForVerifyDto;

@Service
public class EmailActivationManager implements EmailActivationService {
	private final EmailActivationDao emailActivationDao;
	private final EmailService emailService;

	@Autowired
	public EmailActivationManager(final EmailActivationDao emailActivationDao, final EmailService emailService) {
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(final EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);
		return new SuccessResult(Messages.emailActivationAdded);
	}

	@Override
	public Result createAndSendByMail(final int userId, final String email) {
		final EmailActivation emailActivation = new EmailActivation(0, userId, "123456789TEST", email, false);
		// TODO create authToken
		emailActivationDao.save(emailActivation);

		emailService.send(email,
				Messages.emailActivationVerifyEmailTitle,
				Messages.emailActivationVerifyEmailBody + "www.localhost:8080/api/emailactivations/verify?authToken="
						+ emailActivation.getAuthToken() + "&email=" + email);

		return new SuccessResult(Messages.emailActivationCreatedAndSent);
	}

	@Override
	public Result delete(final EmailActivation emailActivation) {
		emailActivationDao.delete(emailActivation);

		return new SuccessResult(Messages.emailActivationDeleted);
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		final List<EmailActivation> emailActivations = emailActivationDao.findAll();

		return new SuccessDataResult<List<EmailActivation>>(emailActivations);
	}

	@Override
	public DataResult<EmailActivation> getById(final int id) {
		final EmailActivation emailActivation = emailActivationDao.findById(id).get();

		return new SuccessDataResult<EmailActivation>(emailActivation);
	}

	@Override
	public Result update(final EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);

		return new SuccessResult(Messages.emailActivationUpdated);
	}

	@Override
	public Result verify(final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final EmailActivation emailActivation = emailActivationDao.findByEmailAndAuthToken(
				emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getAuthToken());

		if (emailActivation == null)
			return new ErrorResult(Messages.emailNotVerified);

		emailActivation.setApproved(true);
		emailActivationDao.save(emailActivation);

		return new SuccessResult(Messages.emailVerified);
	}

}
