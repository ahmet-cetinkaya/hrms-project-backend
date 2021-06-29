package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WorkingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Short> {
}
