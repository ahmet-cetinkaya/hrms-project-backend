package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVWebSite;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerCVWebSiteDao extends JpaRepository<JobSeekerCVWebSite, Integer> {
    List<JobSeekerCVWebSite> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
