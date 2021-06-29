package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WorkingTimeService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.WorkingTimeDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WorkingTime;
import org.springframework.stereotype.Service;

@Service
public class WorkingTimeManager extends BaseManager<WorkingTimeDao, WorkingTime, Short> implements WorkingTimeService {
    public WorkingTimeManager(final WorkingTimeDao workingTimeDao) {
        super(workingTimeDao, "Working time");
    }
}
