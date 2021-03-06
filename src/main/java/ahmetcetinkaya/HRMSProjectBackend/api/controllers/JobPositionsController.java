package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobPositionService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController extends BaseController<JobPositionService, JobPosition, Integer> {
	@Autowired
	public JobPositionsController(final JobPositionService jobPositionService) {
		super(jobPositionService);
	}
}