package ahmetcetinkaya.HRMSProjectBackend.core.utilities.business;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;

public class BusinessRules {
    public static Result run(final Result... logics) {
        for (final Result logic : logics)
            if (!logic.isSuccess())
                return logic;
        return new SuccessResult();
    }
}
