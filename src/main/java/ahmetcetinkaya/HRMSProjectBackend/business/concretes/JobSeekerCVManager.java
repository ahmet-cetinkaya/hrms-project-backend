package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCVManager extends BaseManager<JobSeekerCVDao, JobSeekerCV, Integer> implements JobSeekerCVService {
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
            return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

        return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
    }

}
