package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
