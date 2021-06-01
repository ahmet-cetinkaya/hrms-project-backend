package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceService extends BaseService<JobSeekerExperience, Integer> {
	DataResult<List<JobSeekerExperience>> getAllByJobSeeker_Id(int jobSeekerId);

	DataResult<List<JobSeekerExperience>> getAllByJobSeeker_IdOrderByQuitDate(int jobSeekerId, Direction direction);
}
