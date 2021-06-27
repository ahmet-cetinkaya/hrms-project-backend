package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVExperience;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVExperienceDao extends JpaRepository<JobSeekerCVExperience, Integer> {
    List<JobSeekerCVExperience> findAllByJobSeekerCV_Id(int jobSeekerCVId);

    List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId);

    List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDateDesc(int jobSeekerCVId);
}
