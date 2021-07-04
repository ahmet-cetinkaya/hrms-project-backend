package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmailActivation;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer> {
	Optional<EmailActivation> findByEmailAndActivationCode(String email, String activationCode);
}
