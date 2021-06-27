package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVImage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer> {
    List<JobSeekerCVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
