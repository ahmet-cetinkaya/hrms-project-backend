package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVEducation;

public interface JobSeekerCVEducationService extends BaseService<JobSeekerCVEducation, Integer> {
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);
}
