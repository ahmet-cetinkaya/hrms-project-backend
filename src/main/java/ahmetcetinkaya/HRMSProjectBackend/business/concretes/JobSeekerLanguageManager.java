package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerLanguageService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerLanguageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {
	private JobSeekerLanguageDao jobSeekerLanguageDao;

	@Autowired
	public JobSeekerLanguageManager(final JobSeekerLanguageDao jobSeekerLanguageDao) {
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public Result add(final JobSeekerLanguage jobSeekerLanguage) {
		jobSeekerLanguageDao.save(jobSeekerLanguage);

		return new SuccessResult(Messages.JobSeekerLanguageAdded);
	}

	@Override
	public Result delete(final JobSeekerLanguage jobSeekerLanguage) {
		jobSeekerLanguageDao.delete(jobSeekerLanguage);

		return new SuccessResult(Messages.JobSeekerLanguageDeleted);
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAll() {
		final List<JobSeekerLanguage> jobSeekerLanguages = jobSeekerLanguageDao.findAll();

		return new SuccessDataResult<List<JobSeekerLanguage>>(jobSeekerLanguages);
	}

	@Override
	public DataResult<JobSeekerLanguage> getById(final Integer id) {
		final Optional<JobSeekerLanguage> jobSeekerLanguage = jobSeekerLanguageDao.findById(id);

		if (jobSeekerLanguage.isEmpty())
			return new ErrorDataResult<JobSeekerLanguage>(Messages.JobSeekerLanguageNotFound);

		return new SuccessDataResult<JobSeekerLanguage>(jobSeekerLanguage.get());
	}

	@Override
	public Result update(final JobSeekerLanguage jobSeekerLanguage) {
		jobSeekerLanguageDao.save(jobSeekerLanguage);

		return new SuccessResult(Messages.JobSeekerLanguageUpdated);
	}

}
