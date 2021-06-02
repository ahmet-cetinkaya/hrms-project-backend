package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerWebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerWebSiteDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerWebSite;

@Service
public class JobSeekerWebSiteManager implements JobSeekerWebSiteService {
	private JobSeekerWebSiteDao jobSeekerWebSiteDao;

	@Autowired
	public JobSeekerWebSiteManager(final JobSeekerWebSiteDao jobSeekerWebSiteDao) {
		this.jobSeekerWebSiteDao = jobSeekerWebSiteDao;
	}

	@Override
	public Result add(final JobSeekerWebSite jobSeekerWebSite) {
		jobSeekerWebSiteDao.save(jobSeekerWebSite);

		return new SuccessResult(Messages.JobSeekerWebSiteAdded);
	}

	@Override
	public Result delete(final JobSeekerWebSite jobSeekerWebSite) {
		jobSeekerWebSiteDao.delete(jobSeekerWebSite);

		return new SuccessResult(Messages.JobSeekerWebSiteDeleted);
	}

	@Override
	public DataResult<List<JobSeekerWebSite>> getAll() {
		final List<JobSeekerWebSite> jobSeekerWebSites = jobSeekerWebSiteDao.findAll();

		return new SuccessDataResult<List<JobSeekerWebSite>>(jobSeekerWebSites);
	}

	@Override
	public DataResult<List<JobSeekerWebSite>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final List<JobSeekerWebSite> jobSeekerWebSites = jobSeekerWebSiteDao.findAllByJobSeeker_Id(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerWebSite>>(jobSeekerWebSites);
	}

	@Override
	public DataResult<JobSeekerWebSite> getById(final Integer id) {
		final Optional<JobSeekerWebSite> jobSeekerWebSite = jobSeekerWebSiteDao.findById(id);

		if (jobSeekerWebSite.isEmpty())
			return new ErrorDataResult<JobSeekerWebSite>(Messages.JobSeekerWebSiteNotFound);

		return new SuccessDataResult<JobSeekerWebSite>(jobSeekerWebSite.get());
	}

	@Override
	public Result update(final JobSeekerWebSite jobSeekerWebSite) {
		jobSeekerWebSiteDao.save(jobSeekerWebSite);

		return new SuccessResult(Messages.JobSeekerWebSiteUpdated);
	}
}
