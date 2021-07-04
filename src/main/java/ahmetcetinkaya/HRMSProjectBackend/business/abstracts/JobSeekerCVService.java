package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;

public interface JobSeekerCVService extends BaseService<JobSeekerCV, Integer> {
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);
}
