package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVEducationService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVEducationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVEducation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerCVEducationManager extends BaseManager<JobSeekerCVEducationDao, JobSeekerCVEducation, Integer> implements JobSeekerCVEducationService {
    private final JobSeekerCVEducationDao jobSeekerCVEducationDao;

    @Autowired
    public JobSeekerCVEducationManager(final JobSeekerCVEducationDao jobSeekerCVEducationDao) {
        super(jobSeekerCVEducationDao, "Job seeker CV education");
        this.jobSeekerCVEducationDao = jobSeekerCVEducationDao;
    }

    @Override
    public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final List<JobSeekerCVEducation> jobSeekerCVEducations = jobSeekerCVEducationDao
                .findAllByJobSeekerCV_Id(jobSeekerCVId);

        return new SuccessDataResult<List<JobSeekerCVEducation>>(jobSeekerCVEducations);
    }

    @Override
    public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(final int jobSeekerCVId,
                                                                                              final Direction direction) {
        final List<JobSeekerCVEducation> jobSeekerCVEducations = direction.isAscending()
                ? jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId)
                : jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId);

        return new SuccessDataResult<List<JobSeekerCVEducation>>(jobSeekerCVEducations);
    }

}
