package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerEducationService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerEducation;

@RestController
@RequestMapping("/api/jobseekereducations")
public class JobSeekerEducationsController {
	private JobSeekerEducationService jobSeekerEducationService;

	@Autowired
	public JobSeekerEducationsController(final JobSeekerEducationService jobSeekerEducationService) {
		this.jobSeekerEducationService = jobSeekerEducationService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerEducation jobSeekerEducation) {
		final Result result = jobSeekerEducationService.add(jobSeekerEducation);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerEducation jobSeekerEducation) {
		final Result result = jobSeekerEducationService.delete(jobSeekerEducation);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerEducation>>> getAll() {
		final DataResult<List<JobSeekerEducation>> result = jobSeekerEducationService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekerid")
	public ResponseEntity<DataResult<List<JobSeekerEducation>>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<List<JobSeekerEducation>> result = jobSeekerEducationService.getAllByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekeridorderbygraduationdate")
	public ResponseEntity<DataResult<List<JobSeekerEducation>>> getAllByJobSeeker_IdOrderByGraduationDate(
			@RequestParam final int jobSeekerId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerEducation>> result = jobSeekerEducationService
				.getAllByJobSeeker_IdOrderByGraduationDate(jobSeekerId, direction);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerEducation jobSeekerEducation) {
		final Result result = jobSeekerEducationService.update(jobSeekerEducation);

		return ResponseEntity.ok(result);
	}

}
