package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVExperience;
import java.util.List;
import org.springframework.data.domain.Sort.Direction;

public interface JobSeekerCVExperienceService extends BaseService<JobSeekerCVExperience, Integer> {
    DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

    DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
                                                                                  Direction direction);
}
