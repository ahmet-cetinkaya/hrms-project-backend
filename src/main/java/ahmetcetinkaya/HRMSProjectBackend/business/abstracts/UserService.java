package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.entities.User;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;

public interface UserService extends BaseService<User> {
	DataResult<User> getByEmail(String email);

	Result isNotEmailExist(final String email);
}
