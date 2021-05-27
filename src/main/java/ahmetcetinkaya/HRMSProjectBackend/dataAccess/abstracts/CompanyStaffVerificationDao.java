package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationDao extends JpaRepository<CompanyStaffVerification, Integer> {

}
