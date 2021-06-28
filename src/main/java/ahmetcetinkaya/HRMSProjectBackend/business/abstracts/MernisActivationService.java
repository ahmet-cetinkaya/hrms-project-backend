package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.business.adapters.mernisService.PersonForValidateFromMernisService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.MernisActivation;

public interface MernisActivationService extends BaseService<MernisActivation, Integer> {
    Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
}