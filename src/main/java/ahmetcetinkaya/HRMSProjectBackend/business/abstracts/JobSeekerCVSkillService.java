package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillService extends BaseService<JobSeekerCVSkill, Integer> {
	DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
