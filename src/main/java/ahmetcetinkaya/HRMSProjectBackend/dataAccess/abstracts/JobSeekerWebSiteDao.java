package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerWebSite;

public interface JobSeekerWebSiteDao extends JpaRepository<JobSeekerWebSite, Integer> {
	List<JobSeekerWebSite> findAllByJobSeeker_Id(int id);
}
