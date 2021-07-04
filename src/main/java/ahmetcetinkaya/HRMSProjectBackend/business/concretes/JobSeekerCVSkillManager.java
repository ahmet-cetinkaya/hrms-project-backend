package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVSkillService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVSkillDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVSkill;

@Service
public class JobSeekerCVSkillManager extends BaseManager<JobSeekerCVSkillDao, JobSeekerCVSkill, Integer>
		implements JobSeekerCVSkillService {
	private final JobSeekerCVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public JobSeekerCVSkillManager(final JobSeekerCVSkillDao jobSeekerCVSkillDao) {
		super(jobSeekerCVSkillDao, "Job seeker CV skill");
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVSkills);
	}

}
