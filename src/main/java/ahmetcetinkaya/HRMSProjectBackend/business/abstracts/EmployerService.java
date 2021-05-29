package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;

public interface EmployerService extends BaseService<Employer> {
	Result isNotCorporateEmailExist(final String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);
}
