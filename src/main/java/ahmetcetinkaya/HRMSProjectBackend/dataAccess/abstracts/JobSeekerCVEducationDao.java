package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVEducation;

public interface JobSeekerCVEducationDao extends JpaRepository<JobSeekerCVEducation, Integer> {
	List<JobSeekerCVEducation> findAllByJobSeekerCV_Id(int jobSeekerId);

	List<JobSeekerCVEducation> findAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId);

	List<JobSeekerCVEducation> findAllByJobSeekerCV_IdOrderByGraduationDateDesc(int jobSeekerCVId);
}
