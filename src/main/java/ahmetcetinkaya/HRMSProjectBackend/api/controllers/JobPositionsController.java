package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobPositionService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	private final JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(final JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobPosition>>> getAll() {
		final DataResult<List<JobPosition>> result = jobPositionService.getAll();

		return ResponseEntity.ok(result);
	}

	@PostMapping("/add")
	public ResponseEntity<Result> getAll(@Valid @RequestBody final JobPosition jobPosition) {
		final Result result = jobPositionService.add(jobPosition);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

}