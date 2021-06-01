package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer> {
	List<JobSeekerExperience> findAllByJobSeeker_Id(int jobSeekerId);

	List<JobSeekerExperience> findAllByJobSeeker_IdOrderByQuitDate(int jobSeekerId);

	List<JobSeekerExperience> findAllByJobSeeker_IdOrderByQuitDateDesc(int jobSeekerId);
}
