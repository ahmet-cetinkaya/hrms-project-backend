package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WebSite;

public interface WebSiteDao extends JpaRepository<WebSite, Short> {
	Optional<WebSite> findByName(String name);
}
