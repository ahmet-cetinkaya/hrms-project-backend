package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.MernisActivation;

public interface MernisActivationDao extends JpaRepository<MernisActivation, Integer> {
	Optional<MernisActivation> findByUserId(int userId);
}