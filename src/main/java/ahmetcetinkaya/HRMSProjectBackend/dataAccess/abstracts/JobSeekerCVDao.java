package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer> {
    Optional<JobSeekerCV> findByJobSeeker_Id(int jobSeekerId);
}
