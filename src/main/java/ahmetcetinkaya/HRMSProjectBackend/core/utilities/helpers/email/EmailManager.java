package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.email;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    @Override
    public Result send(final String to, final String title, final String body) {
        // TODO
        return new SuccessResult("Email has send.");
    }

}
