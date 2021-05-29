package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Optional<Employer> findByCorporateEmail(String corporateEmail);
}
