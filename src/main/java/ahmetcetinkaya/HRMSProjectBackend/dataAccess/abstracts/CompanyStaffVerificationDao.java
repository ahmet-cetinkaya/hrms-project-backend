package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyStaffVerificationDao extends JpaRepository<CompanyStaffVerification, Integer> {
    Optional<CompanyStaffVerification> findByUser_Id(int userId);
}
