package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();

	void add(JobPosition jobPosition);
}
