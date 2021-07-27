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
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.EmployerDao;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.EmployerUpdateDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmployerUpdate;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForUpdateDto;

@Service
public class EmployerManager extends BaseManager<EmployerDao, Employer, Integer> implements EmployerService {
	private final EmployerDao employerDao;
	private final EmployerUpdateDao employerUpdateDao;
	private final UserService userService;
	private final EmailActivationService emailActivationService;
	private final CompanyStaffVerificationService companyStaffVerificationService;

	@Autowired
	public EmployerManager(final EmployerDao employerDao, final EmployerUpdateDao employerUpdateDao,
			final UserService userService, final EmailActivationService emailActivationService,
			final CompanyStaffVerificationService companyStaffVerificationService) {
		super(employerDao, "Employer");
		this.employerDao = employerDao;
		this.employerUpdateDao = employerUpdateDao;
		this.userService = userService;
		this.emailActivationService = emailActivationService;
		this.companyStaffVerificationService = companyStaffVerificationService;
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult()
				: new ErrorResult(ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.passwordsNotMatch);
	}

	private Result isCorporateEmail(final String email, final String website) {
		return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult(Messages.emailNotCorporate);
	}

	@Override
	public DataResult<EmployerUpdate> getLastUpdateByUserId(final int employerId) {
		final List<EmployerUpdate> employerUpdates = employerUpdateDao
				.findAllByEmployer_IdOrderByUpdatedAtDesc(employerId);

		if (employerUpdates.size() == 0)
			return new ErrorDataResult<>(ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages
					.notFound("Pending update approval"));

		return new SuccessDataResult<EmployerUpdate>(employerUpdates.get(0));
	}

	@Override
	public DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(final boolean isApproved,
			final boolean isDeleted) {
		final List<EmployerUpdate> employerUpdates = employerUpdateDao.findAllByIsApprovedAndIsDeleted(isApproved,
				isDeleted);

		return new SuccessDataResult<List<EmployerUpdate>>(employerUpdates);
	}

	@Override
	public Result isNotCorporateEmailExist(final String corporateEmail) {
		return employerDao.findByCorporateEmail(corporateEmail).isEmpty() ? new SuccessResult()
				: new ErrorResult(ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages
						.alreadyExists("A employer with the corporate email"));
	}

	@Override
	public Result register(final EmployerForRegisterDto employerForRegister) {
		final Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(employerForRegister.getEmail()),
				isNotCorporateEmailExist(employerForRegister.getCorporateEmail()),
				arePasswordMatch(employerForRegister.getPassword(), employerForRegister.getConfirmPassword()),
				isCorporateEmail(employerForRegister.getCorporateEmail(), employerForRegister.getWebsite()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final Employer employer = Employer.childBuilder()
				.email(employerForRegister.getEmail())
				.password(employerForRegister.getPassword())
				.companyName(employerForRegister.getCompanyName())
				.website(employerForRegister.getWebsite())
				.corporateEmail(employerForRegister.getCorporateEmail())
				.phone(employerForRegister.getPhone())
				.build();
		super.add(employer);

		emailActivationService
				.createAndSendActivationCodeByMail(employer, employer.getEmail(), employer.getCorporateEmail());
		companyStaffVerificationService.add(CompanyStaffVerification.builder().user(employer).build());

		return new SuccessResult(
				ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.complete("Employer registration"));
	}

	@Override
	public Result updateByUser(final EmployerForUpdateDto employerForUpdateDto) {
		final Optional<Employer> employer = employerDao.findById(employerForUpdateDto.getEmployerId());
		if (employer.isEmpty())
			return new ErrorResult(
					ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.notFound("Employer"));

		final Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(employer.get().getPassword(), employerForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final EmployerUpdate employerUpdate = EmployerUpdate.builder()
				.employer(employer.get())
				.companyName(employerForUpdateDto.getCompanyName())
				.website(employerForUpdateDto.getWebsite())
				.corporateEmail(employerForUpdateDto.getCorporateEmail())
				.phone(employerForUpdateDto.getPhone())
				.build();
		employerUpdateDao.save(employerUpdate);

		return new SuccessResult(
				ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.awaitingApproval("Employer update"));
	}

	@Override
	public Result verifyUpdate(final int employerUpdateId) {
		final Optional<EmployerUpdate> employerUpdate = employerUpdateDao.findById(employerUpdateId);
		if (employerUpdate.isEmpty())
			return new ErrorResult(
					ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.notFound("Employer update"));

		final Employer employer = super.getById(employerUpdate.get().getEmployer().getId()).getData();
		employer.setCompanyName(employerUpdate.get().getCompanyName());
		employer.setWebsite(employerUpdate.get().getWebsite());
		employer.setCorporateEmail(employerUpdate.get().getCorporateEmail());
		employer.setPhone(employerUpdate.get().getPhone());
		super.update(employer);

		employerUpdate.get().setApproved(true);
		employerUpdate.get().setDeleted(true);
		employerUpdateDao.save(employerUpdate.get());

		return new SuccessResult(
				ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.verified("Employer update"));
	}

}
