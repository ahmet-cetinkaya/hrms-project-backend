package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WorkingTypeService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingtypes")
public class WorkingTypesController extends BaseController<WorkingTypeService, WorkingType, Short> {
	public WorkingTypesController(final WorkingTypeService workingTypeService) {
		super(workingTypeService);
	}
}
