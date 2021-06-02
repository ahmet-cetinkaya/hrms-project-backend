package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerSkill;

public interface JobSeekerSkillService extends BaseService<JobSeekerSkill, Integer> {
	DataResult<List<JobSeekerSkill>> getAllByJobSeeker_Id(int jobSeekerId);
}
