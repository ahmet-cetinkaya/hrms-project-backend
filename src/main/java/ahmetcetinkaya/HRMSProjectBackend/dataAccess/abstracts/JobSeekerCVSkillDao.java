package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillDao extends JpaRepository<JobSeekerCVSkill, Integer> {
	List<JobSeekerCVSkill> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
