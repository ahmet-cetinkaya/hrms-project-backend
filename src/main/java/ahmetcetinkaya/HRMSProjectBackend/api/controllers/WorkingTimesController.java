package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.WorkingTimeService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingtimes")
public class WorkingTimesController extends BaseController<WorkingTimeService, WorkingTime, Short> {
	public WorkingTimesController(final WorkingTimeService workingTimeService) {
		super(workingTimeService);
	}
}
