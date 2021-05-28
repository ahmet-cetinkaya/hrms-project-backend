package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffVerificationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmailActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmployerService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.EmployerDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.User;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;

@Service
public class EmployerManager implements EmployerService {
	private final EmployerDao employerDao;
	private final UserService userService;
	private final EmailActivationService emailActivationService;
	private final CompanyStaffVerificationService companyStaffVerificationService;

	@Autowired
	public EmployerManager(final EmployerDao employerDao, final UserService userService,
			final EmailActivationService emailActivationService,
			final CompanyStaffVerificationService companyStaffVerificationService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailActivationService = emailActivationService;
		this.companyStaffVerificationService = companyStaffVerificationService;
	}

	@Override
	public Result add(final Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}

	@Override
	public Result delete(final Employer employer) {
		employerDao.delete(employer);
		return new SuccessResult(Messages.employerDeleted);
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		final List<Employer> employers = employerDao.findAll();
		return new SuccessDataResult<List<Employer>>(employers);
	}

	@Override
	public DataResult<Employer> getById(final int id) {
		final Optional<Employer> employer = employerDao.findById(id);

		if (employer.isEmpty())
			return new ErrorDataResult<Employer>(Messages.employerNotFound);

		return new SuccessDataResult<Employer>(employer.get());
	}

	private Result isCorporateEmail(final String email, final String website) {
		return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult(Messages.emailNotCorporate);
	}

	private Result isNotCorporateEmailExist(final String corporateEmail) {
		return employerDao.findByCorporateEmail(corporateEmail).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.employerWithCorporateEmailAlreadyExits);
	}

	@Override
	public Result register(final EmployerForRegisterDto employerForRegister) {
		final Result businessRulesResult = BusinessRules.run(
				isNotCorporateEmailExist(employerForRegister.getCorporateEmail()),
				arePasswordMatch(employerForRegister.getPassword(), employerForRegister.getConfirmPassword()),
				isCorporateEmail(employerForRegister.getCorporateEmail(), employerForRegister.getWebsite()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final User user = new User(0, employerForRegister.getEmail(), employerForRegister.getPassword());
		final Result userRegisterResult = userService.register(user);
		if (!userRegisterResult.isSuccess())
			return userRegisterResult;

		final Employer employer = new Employer(user.getId(),
				employerForRegister.getCompanyName(),
				employerForRegister.getWebsite(),
				employerForRegister.getCorporateEmail(),
				employerForRegister.getPhone());
		add(employer);

		emailActivationService.createAndSendByMail(user.getId(), employer.getCorporateEmail());

		final CompanyStaffVerification companyStaffVerification = new CompanyStaffVerification(0,
				employer.getUserId(),
				false);
		companyStaffVerificationService.add(companyStaffVerification);

		return new SuccessResult(Messages.employerRegistered);
	}

	@Override
	public Result update(final Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(Messages.employerUpdated);
	}

}
