package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVWebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVWebSite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCVWebSiteManager extends BaseManager<JobSeekerCVWebSiteDao, JobSeekerCVWebSite, Integer> implements JobSeekerCVWebSiteService {
    private final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;

    @Autowired
    public JobSeekerCVWebSiteManager(final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao) {
        super(jobSeekerCVWebSiteDao, "Job seeker CV webSite");
        this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
    }

    @Override
    public DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
                .findAllByJobSeekerCV_Id(jobSeekerCVId);

        return new SuccessDataResult<List<JobSeekerCVWebSite>>(jobSeekerCVWebSites);
    }

}
