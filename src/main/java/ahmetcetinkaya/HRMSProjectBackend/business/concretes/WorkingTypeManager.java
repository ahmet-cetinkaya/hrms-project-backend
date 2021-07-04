package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WorkingTypeService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.WorkingTypeDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager extends BaseManager<WorkingTypeDao, WorkingType, Short> implements WorkingTypeService {
	public WorkingTypeManager(final WorkingTypeDao workingTypeDao) {
		super(workingTypeDao, "Working type");
	}
}
