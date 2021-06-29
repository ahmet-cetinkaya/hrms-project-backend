package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffVerificationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmailActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmployerService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.EmployerDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager extends BaseManager<EmployerDao, Employer, Integer> implements EmployerService {
    private final EmployerDao employerDao;
    private final UserService userService;
    private final EmailActivationService emailActivationService;
    private final CompanyStaffVerificationService companyStaffVerificationService;

    @Autowired
    public EmployerManager(final EmployerDao employerDao, final UserService userService,
                           final EmailActivationService emailActivationService,
                           final CompanyStaffVerificationService companyStaffVerificationService) {
        super(employerDao, "Employer");
        this.employerDao = employerDao;
        this.userService = userService;
        this.emailActivationService = emailActivationService;
        this.companyStaffVerificationService = companyStaffVerificationService;
    }

    private Result arePasswordMatch(final String password, final String confirmPassword) {
        return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
    }

    private Result isCorporateEmail(final String email, final String website) {
        return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult(Messages.emailNotCorporate);
    }

    @Override
    public Result isNotCorporateEmailExist(final String corporateEmail) {
        return employerDao.findByCorporateEmail(corporateEmail).isEmpty() ? new SuccessResult()
                : new ErrorResult(Messages.employerWithCorporateEmailAlreadyExits);
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

        return new SuccessResult(Messages.employerRegistered);
    }

}
