package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmailActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.MernisActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.UserService;
import ahmetcetinkaya.HRMSProjectBackend.business.adapters.mernisService.PersonForValidateFromMernisService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeeker;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.MernisActivation;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobSeekerForRegisterDto;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerManager extends BaseManager<JobSeekerDao, JobSeeker, Integer> implements JobSeekerService {
    private final JobSeekerDao jobSeekerDao;
    private final UserService userService;
    private final MernisActivationService mernisActivationService;
    private final EmailActivationService emailActivationService;

    @Autowired
    public JobSeekerManager(final JobSeekerDao jobSeekerDao, final UserService userService,
                            final MernisActivationService mernisActivationService,
                            final EmailActivationService emailActivationService) {
        super(jobSeekerDao, "Job seeker");
        this.jobSeekerDao = jobSeekerDao;
        this.userService = userService;
        this.mernisActivationService = mernisActivationService;
        this.emailActivationService = emailActivationService;
    }

    private Result arePasswordMatch(final String password, final String confirmPassword) {
        return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
    }

    @Override
    public DataResult<JobSeeker> getByIdentityNumber(final String identityNumber) {
        final Optional<JobSeeker> jobSeeker = jobSeekerDao.findByIdentityNumber(identityNumber);

        if (jobSeeker.isEmpty())
            return new ErrorDataResult<JobSeeker>(Messages.jobSeekerNotFound);

        return new SuccessDataResult<JobSeeker>(jobSeeker.get());
    }

    @Override
    public Result isNotNationalIdentityExist(final String identityNumber) {
        return jobSeekerDao.findByIdentityNumber(identityNumber).isEmpty() ? new SuccessResult()
                : new ErrorResult(Messages.jobSeekerWithIdentityNumberAlreadyExits);
    }

    @Override
    public Result register(final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        final Result businessRulesResult = BusinessRules.run(
                userService.isNotEmailExist(jobSeekerForRegisterDto.getEmail()),
                isNotNationalIdentityExist(jobSeekerForRegisterDto.getIdentityNumber()),
                arePasswordMatch(jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getConfirmPassword()),
                mernisActivationService.check(PersonForValidateFromMernisService.builder()
                        .ad(jobSeekerForRegisterDto.getFirstName())
                        .soyad(jobSeekerForRegisterDto.getLastName())
                        .TCKimlikNo(Long.parseLong(jobSeekerForRegisterDto.getIdentityNumber()))
                        .dogumYili(jobSeekerForRegisterDto.getBirthDate().getYear())
                        .build())
        );
        if (!businessRulesResult.isSuccess())
            return businessRulesResult;

        final JobSeeker jobSeeker = JobSeeker.childBuilder()
                .email(jobSeekerForRegisterDto.getEmail())
                .password(jobSeekerForRegisterDto.getPassword())
                .firstName(jobSeekerForRegisterDto.getFirstName())
                .lastName(jobSeekerForRegisterDto.getLastName())
                .identityNumber(jobSeekerForRegisterDto.getIdentityNumber())
                .birthDate(jobSeekerForRegisterDto.getBirthDate())
                .build();

        super.add(jobSeeker);

        emailActivationService.createAndSendActivationCodeByMail(jobSeeker, jobSeeker.getEmail());
        mernisActivationService.add(MernisActivation.builder().user(jobSeeker).build());

        return new SuccessResult(Messages.jobSeekerAdded);
    }

}
