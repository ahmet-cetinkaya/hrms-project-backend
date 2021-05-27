package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker findByIdentityNumber(String identityNumber);
}
