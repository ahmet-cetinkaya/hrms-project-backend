package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;

@RestController
@RequestMapping("/api/jobseekers/cvs")
public class JobSeekerCVsController {
	private JobSeekerCVService jobSeekerCVService;

	@Autowired
	public JobSeekerCVsController(final JobSeekerCVService jobSeekerCVService) {
		this.jobSeekerCVService = jobSeekerCVService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCV jobSeekerCV) {
		final Result result = jobSeekerCVService.add(jobSeekerCV);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerCV jobSeekerCV) {
		final Result result = jobSeekerCVService.delete(jobSeekerCV);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerCV>>> getAll() {
		final DataResult<List<JobSeekerCV>> result = jobSeekerCVService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byid")
	public ResponseEntity<DataResult<JobSeekerCV>> getById(final int id) {
		final DataResult<JobSeekerCV> result = jobSeekerCVService.getById(id);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byjobseekerid")
	public ResponseEntity<DataResult<JobSeekerCV>> getByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<JobSeekerCV> result = jobSeekerCVService.getByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCV jobSeekerCV) {
		final Result result = jobSeekerCVService.update(jobSeekerCV);

		return ResponseEntity.ok(result);
	}
}
