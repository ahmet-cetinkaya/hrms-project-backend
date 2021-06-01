package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerImage;

public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage, Integer> {
	List<JobSeekerImage> findAllByJobSeeker_Id(int jobSeekerId);
}
