package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationService extends BaseService<JobSeekerEducation> {
	DataResult<List<JobSeekerEducation>> getAllByJobSeeker_Id(int jobSeekerId);

	DataResult<List<JobSeekerEducation>> getAllByJobSeeker_IdOrderByGraduationDate(int jobSeekerId,
			Direction direction);
}
