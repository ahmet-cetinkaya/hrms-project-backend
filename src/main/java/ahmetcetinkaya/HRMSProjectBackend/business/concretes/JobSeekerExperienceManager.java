package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerExperienceService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerExperienceDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerExperience;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {
	private JobSeekerExperienceDao jobSeekerExperienceDao;

	@Autowired
	public JobSeekerExperienceManager(final JobSeekerExperienceDao jobSeekerExperienceDao) {
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
	}

	@Override
	public Result add(final JobSeekerExperience jobSeekerExperience) {
		jobSeekerExperienceDao.save(jobSeekerExperience);

		return new SuccessResult(Messages.JobSeekerExperienceAdded);
	}

	@Override
	public Result delete(final JobSeekerExperience jobSeekerExperience) {
		jobSeekerExperienceDao.delete(jobSeekerExperience);

		return new SuccessResult(Messages.JobSeekerExperienceDeleted);
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAll() {
		final List<JobSeekerExperience> jobSeekerExperiences = jobSeekerExperienceDao.findAll();

		return new SuccessDataResult<List<JobSeekerExperience>>(jobSeekerExperiences);
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final List<JobSeekerExperience> jobSeekerExperiences = jobSeekerExperienceDao
				.findAllByJobSeeker_Id(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerExperience>>(jobSeekerExperiences);
	}

	@Override
	public DataResult<List<JobSeekerExperience>> getAllByJobSeeker_IdOrderByQuitDate(final int jobSeekerId,
			final Direction direction) {
		final List<JobSeekerExperience> jobSeekerEducations = direction.isAscending()
				? jobSeekerExperienceDao.findAllByJobSeeker_IdOrderByQuitDate(jobSeekerId)
				: jobSeekerExperienceDao.findAllByJobSeeker_IdOrderByQuitDateDesc(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerExperience>>(jobSeekerEducations);
	}

	@Override
	public DataResult<JobSeekerExperience> getById(final int id) {
		final Optional<JobSeekerExperience> jobSeekerExperience = jobSeekerExperienceDao.findById(id);

		if (jobSeekerExperience.isEmpty())
			return new ErrorDataResult<JobSeekerExperience>(Messages.JobSeekerExperienceNotFound);

		return new SuccessDataResult<JobSeekerExperience>(jobSeekerExperience.get());
	}

	@Override
	public Result update(final JobSeekerExperience jobSeekerExperience) {
		jobSeekerExperienceDao.save(jobSeekerExperience);

		return new SuccessResult(Messages.JobSeekerExperienceUpdated);
	}

}
