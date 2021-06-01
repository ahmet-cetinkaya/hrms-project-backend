package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {

}
