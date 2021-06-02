package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerSkill;

public interface JobSeekerSkillDao extends JpaRepository<JobSeekerSkill, Integer> {
	List<JobSeekerSkill> findAllByJobSeeker_Id(int jobSeekerId);
}
