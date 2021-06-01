package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerEducation;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {
	List<JobSeekerEducation> findAllByJobSeeker_Id(int jobSeekerId);

	List<JobSeekerEducation> findAllByJobSeeker_IdOrderByGraduationDate(int jobSeekerId);

	List<JobSeekerEducation> findAllByJobSeeker_IdOrderByGraduationDateDesc(int jobSeekerId);
}
