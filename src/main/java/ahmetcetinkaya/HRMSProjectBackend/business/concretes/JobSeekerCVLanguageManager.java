package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVLanguageService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVLanguageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVLanguage;

@Service
public class JobSeekerCVLanguageManager extends BaseManager<JobSeekerCVLanguageDao, JobSeekerCVLanguage, Integer>
		implements JobSeekerCVLanguageService {
	private final JobSeekerCVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public JobSeekerCVLanguageManager(final JobSeekerCVLanguageDao jobSeekerCVLanguageDao) {
		super(jobSeekerCVLanguageDao, "Job seeker CV language");
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVLanguages);
	}

}