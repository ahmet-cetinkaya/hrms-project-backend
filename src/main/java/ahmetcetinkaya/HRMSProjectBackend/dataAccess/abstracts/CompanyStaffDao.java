package ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaff;

public interface CompanyStaffDao extends JpaRepository<CompanyStaff, Integer> {
}
