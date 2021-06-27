package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.email;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;

public interface EmailService {
    Result send(String to, String title, String body);
}
