package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, String> {

}
