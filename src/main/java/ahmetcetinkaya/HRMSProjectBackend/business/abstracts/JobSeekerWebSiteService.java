package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerWebSite;

public interface JobSeekerWebSiteService extends BaseService<JobSeekerWebSite, Integer> {
	DataResult<List<JobSeekerWebSite>> getAllByJobSeeker_Id(int jobSeekerId);
}
