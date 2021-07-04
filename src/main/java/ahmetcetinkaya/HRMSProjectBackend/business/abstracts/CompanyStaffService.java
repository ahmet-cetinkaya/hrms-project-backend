package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaff;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.CompanyStaffForUpdateDto;

public interface CompanyStaffService extends BaseService<CompanyStaff, Integer> {
	Result updateByUser(CompanyStaffForUpdateDto companyStaffForUpdateDto);
}
