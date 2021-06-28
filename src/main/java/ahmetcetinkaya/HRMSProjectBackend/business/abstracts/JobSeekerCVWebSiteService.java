package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVWebSite;
import java.util.List;

public interface JobSeekerCVWebSiteService extends BaseService<JobSeekerCVWebSite, Integer> {
    DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
