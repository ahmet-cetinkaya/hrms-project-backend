package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer> {
	Optional<JobSeekerCV> findByJobSeeker_Id(int jobSeekerId);
}
