package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Short> {
}
