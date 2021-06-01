package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerEducationService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerEducationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerEducation;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {
	private JobSeekerEducationDao jobSeekerEducationDao;

	@Autowired
	public JobSeekerEducationManager(final JobSeekerEducationDao jobSeekerEducationDao) {
		this.jobSeekerEducationDao = jobSeekerEducationDao;
	}

	@Override
	public Result add(final JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.save(jobSeekerEducation);

		return new SuccessResult(Messages.JobSeekerEducationAdded);
	}

	@Override
	public Result delete(final JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.delete(jobSeekerEducation);

		return new SuccessResult(Messages.JobSeekerEducationDeleted);
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAll() {
		final List<JobSeekerEducation> jobSeekerEducations = jobSeekerEducationDao.findAll();

		return new SuccessDataResult<List<JobSeekerEducation>>(jobSeekerEducations);
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final List<JobSeekerEducation> jobSeekerEducations = jobSeekerEducationDao.findAllByJobSeeker_Id(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerEducation>>(jobSeekerEducations);
	}

	@Override
	public DataResult<List<JobSeekerEducation>> getAllByJobSeeker_IdOrderByGraduationDate(final int jobSeekerId,
			final Direction direction) {
		final List<JobSeekerEducation> jobSeekerEducations = direction.isAscending()
				? jobSeekerEducationDao.findAllByJobSeeker_IdOrderByGraduationDate(jobSeekerId)
				: jobSeekerEducationDao.findAllByJobSeeker_IdOrderByGraduationDateDesc(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerEducation>>(jobSeekerEducations);
	}

	@Override
	public DataResult<JobSeekerEducation> getById(final int id) {
		final Optional<JobSeekerEducation> jobSeekerEducation = jobSeekerEducationDao.findById(id);

		if (jobSeekerEducation.isEmpty())
			return new ErrorDataResult<JobSeekerEducation>(Messages.JobSeekerEducationNotFound);

		return new SuccessDataResult<JobSeekerEducation>(jobSeekerEducation.get());
	}

	@Override
	public Result update(final JobSeekerEducation jobSeekerEducation) {
		jobSeekerEducationDao.save(jobSeekerEducation);

		return new SuccessResult(Messages.JobSeekerEducationUpdated);
	}

}
