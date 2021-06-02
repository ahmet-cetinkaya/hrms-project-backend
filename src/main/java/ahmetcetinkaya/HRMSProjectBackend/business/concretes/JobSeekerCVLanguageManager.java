package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVLanguageService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVLanguageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVLanguage;

@Service
public class JobSeekerCVLanguageManager implements JobSeekerCVLanguageService {
	private JobSeekerCVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public JobSeekerCVLanguageManager(final JobSeekerCVLanguageDao jobSeekerCVLanguageDao) {
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public Result add(final JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);

		return new SuccessResult(Messages.jobSeekerCVLanguageAdded);
	}

	@Override
	public Result delete(final JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.delete(jobSeekerCVLanguage);

		return new SuccessResult(Messages.jobSeekerCVLanguageDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAll() {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVLanguage>>(jobSeekerCVLanguages);
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVLanguage>>(jobSeekerCVLanguages);
	}

	@Override
	public DataResult<JobSeekerCVLanguage> getById(final Integer id) {
		final Optional<JobSeekerCVLanguage> jobSeekerCVLanguage = jobSeekerCVLanguageDao.findById(id);

		if (jobSeekerCVLanguage.isEmpty())
			return new ErrorDataResult<JobSeekerCVLanguage>(Messages.jobSeekerCVLanguageNotFound);

		return new SuccessDataResult<JobSeekerCVLanguage>(jobSeekerCVLanguage.get());
	}

	@Override
	public Result update(final JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);

		return new SuccessResult(Messages.jobSeekerCVLanguageUpdated);
	}

}
