package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.MernisActivationService;
import ahmetcetinkaya.HRMSProjectBackend.business.adapters.mernisService.PersonForValidateFromMernisService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.MernisActivationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.MernisActivation;

@Service
public class MernisActivationManager extends BaseManager<MernisActivationDao, MernisActivation, Integer>
		implements MernisActivationService {
	private final MernisActivationDao mernisActivationDao;

	@Autowired
	public MernisActivationManager(final MernisActivationDao mernisActivationDao) {
		super(mernisActivationDao, "Mernis activation");
		this.mernisActivationDao = mernisActivationDao;
	}

	@Override
	public Result check(final PersonForValidateFromMernisService personForValidateFromMernisService) {
		// TODO Validate with Mernis System Adapter
		return new SuccessResult(Messages.verified("Mernis activation"));
	}
}
