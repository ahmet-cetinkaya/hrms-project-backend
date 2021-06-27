package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {
    private final JobSeekerCVDao jobSeekerCVDao;

    @Autowired
    public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
        this.jobSeekerCVDao = jobSeekerCVDao;
    }

    @Override
    public Result add(final JobSeekerCV jobSeekerCV) {
        jobSeekerCVDao.save(jobSeekerCV);

        return new SuccessResult(Messages.jobSeekerCVAdded);
    }

    @Override
    public Result delete(final JobSeekerCV jobSeekerCV) {
        jobSeekerCVDao.delete(jobSeekerCV);

        return new SuccessResult(Messages.jobSeekerCVDeleted);
    }

    @Override
    public DataResult<List<JobSeekerCV>> getAll() {
        final List<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findAll();

        return new SuccessDataResult<List<JobSeekerCV>>(jobSeekerCV);
    }

    @Override
    public DataResult<JobSeekerCV> getById(final Integer id) {
        final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findById(id);

        if (jobSeekerCV.isEmpty())
            return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

        return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
    }

    @Override
    public DataResult<JobSeekerCV> getByJobSeeker_Id(final int jobSeekerId) {
        final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

        if (jobSeekerCV.isEmpty())
            return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

        return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
    }

    @Override
    public Result update(final JobSeekerCV jobSeekerCV) {
        jobSeekerCVDao.save(jobSeekerCV);

        return new SuccessResult(Messages.jobSeekerCVUpdated);
    }

}
