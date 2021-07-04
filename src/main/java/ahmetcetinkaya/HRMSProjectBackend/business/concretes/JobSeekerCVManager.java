package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;

@Service
public class JobSeekerCVManager extends BaseManager<JobSeekerCVDao, JobSeekerCV, Integer>
		implements JobSeekerCVService {
	private final JobSeekerCVDao jobSeekerCVDao;

	@Autowired
	public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
		super(jobSeekerCVDao, "Job seeker CV");
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(final int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Job seeker"));

		return new SuccessDataResult<>(jobSeekerCV.get());
	}

}
