package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerSkillService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerSkillDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerSkill;

@Service
public class JobSeekerSkillManager implements JobSeekerSkillService {
	private JobSeekerSkillDao jobSeekerSkillDao;

	@Autowired
	public JobSeekerSkillManager(final JobSeekerSkillDao jobSeekerSkillDao) {
		this.jobSeekerSkillDao = jobSeekerSkillDao;
	}

	@Override
	public Result add(final JobSeekerSkill jobSeekerSkill) {
		jobSeekerSkillDao.save(jobSeekerSkill);

		return new SuccessResult(Messages.JobSeekerSkillAdded);
	}

	@Override
	public Result delete(final JobSeekerSkill jobSeekerSkill) {
		jobSeekerSkillDao.delete(jobSeekerSkill);

		return new SuccessResult(Messages.JobSeekerSkillDeleted);
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAll() {
		final List<JobSeekerSkill> jobSeekerSkills = jobSeekerSkillDao.findAll();

		return new SuccessDataResult<List<JobSeekerSkill>>(jobSeekerSkills);
	}

	@Override
	public DataResult<List<JobSeekerSkill>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final List<JobSeekerSkill> jobSeekerSkills = jobSeekerSkillDao.findAllByJobSeeker_Id(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerSkill>>(jobSeekerSkills);
	}

	@Override
	public DataResult<JobSeekerSkill> getById(final Integer id) {
		final Optional<JobSeekerSkill> jobSeekerSkill = jobSeekerSkillDao.findById(id);

		if (jobSeekerSkill.isEmpty())
			return new ErrorDataResult<JobSeekerSkill>(Messages.JobSeekerSkillNotFound);

		return new SuccessDataResult<JobSeekerSkill>(jobSeekerSkill.get());
	}

	@Override
	public Result update(final JobSeekerSkill jobSeekerSkill) {
		jobSeekerSkillDao.save(jobSeekerSkill);

		return new SuccessResult(Messages.JobSeekerSkillUpdated);
	}

}
