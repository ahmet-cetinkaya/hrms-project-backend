package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.MernisActivation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MernisActivationDao extends JpaRepository<MernisActivation, Integer> {
    Optional<MernisActivation> findByUserId(int userId);
}