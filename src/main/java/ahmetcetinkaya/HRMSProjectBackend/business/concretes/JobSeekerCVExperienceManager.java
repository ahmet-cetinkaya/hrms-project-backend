package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVExperienceService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVExperienceDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVExperience;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCVExperienceManager extends BaseManager<JobSeekerCVExperienceDao, JobSeekerCVExperience, Integer> implements JobSeekerCVExperienceService {
    private final JobSeekerCVExperienceDao jobSeekerCVExperienceDao;

    @Autowired
    public JobSeekerCVExperienceManager(final JobSeekerCVExperienceDao jobSeekerCVExperienceDao) {
        super(jobSeekerCVExperienceDao, "Job seeker CV experience");
        this.jobSeekerCVExperienceDao = jobSeekerCVExperienceDao;
    }

    @Override
    public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final List<JobSeekerCVExperience> jobSeekerCVExperiences = jobSeekerCVExperienceDao
                .findAllByJobSeekerCV_Id(jobSeekerCVId);

        return new SuccessDataResult<List<JobSeekerCVExperience>>(jobSeekerCVExperiences);
    }

    @Override
    public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(final int jobSeekerCVId,
                                                                                         final Direction direction) {
        final List<JobSeekerCVExperience> jobSeekerEducations = direction.isAscending()
                ? jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId)
                : jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDateDesc(jobSeekerCVId);

        return new SuccessDataResult<List<JobSeekerCVExperience>>(jobSeekerEducations);
    }

}
