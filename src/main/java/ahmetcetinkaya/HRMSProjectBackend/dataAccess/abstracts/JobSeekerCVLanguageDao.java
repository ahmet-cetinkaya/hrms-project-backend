package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVLanguage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVLanguageDao extends JpaRepository<JobSeekerCVLanguage, Integer> {
    List<JobSeekerCVLanguage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
