package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVSkill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVSkillDao extends JpaRepository<JobSeekerCVSkill, Integer> {
    List<JobSeekerCVSkill> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
