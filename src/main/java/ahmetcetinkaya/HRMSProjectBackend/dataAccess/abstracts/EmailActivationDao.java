package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmailActivation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailActivationDao extends JpaRepository<EmailActivation, Integer> {
    Optional<EmailActivation> findByEmailAndActivationCode(String email, String activationCode);
}
