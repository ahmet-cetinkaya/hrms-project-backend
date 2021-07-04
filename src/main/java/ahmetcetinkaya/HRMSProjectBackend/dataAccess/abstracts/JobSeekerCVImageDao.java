package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer> {
	List<JobSeekerCVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
