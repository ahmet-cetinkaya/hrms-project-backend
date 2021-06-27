package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WebSite;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteDao extends JpaRepository<WebSite, Short> {
    Optional<WebSite> findByName(String name);
}
