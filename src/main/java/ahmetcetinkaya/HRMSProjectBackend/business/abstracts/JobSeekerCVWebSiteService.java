package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteService extends BaseService<JobSeekerCVWebSite, Integer> {
	DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
