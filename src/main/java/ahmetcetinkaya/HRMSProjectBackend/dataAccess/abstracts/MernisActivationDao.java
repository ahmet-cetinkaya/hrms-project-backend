package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.MernisActivation;

public interface MernisActivationDao extends JpaRepository<MernisActivation, Integer> {
	MernisActivation findByUserId(int userId);
}