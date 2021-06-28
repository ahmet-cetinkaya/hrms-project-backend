package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeeker;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerService extends BaseService<JobSeeker, Integer> {
    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

    Result isNotNationalIdentityExist(String identityNumber);

    Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto);
}
