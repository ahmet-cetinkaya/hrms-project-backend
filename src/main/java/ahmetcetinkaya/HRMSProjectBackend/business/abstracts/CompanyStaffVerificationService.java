package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService extends BaseService<CompanyStaffVerification> {
	DataResult<CompanyStaffVerification> getByUserId(final int userId);

	Result verify(int id);
}
