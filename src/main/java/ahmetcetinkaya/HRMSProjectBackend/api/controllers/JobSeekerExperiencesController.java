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

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerExperienceService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerExperience;

@RestController
@RequestMapping("/api/jobseekers/experiences")
public class JobSeekerExperiencesController {
	private JobSeekerExperienceService jobSeekerExperienceService;

	@Autowired
	public JobSeekerExperiencesController(final JobSeekerExperienceService jobSeekerExperienceService) {
		this.jobSeekerExperienceService = jobSeekerExperienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerExperience jobSeekerExperience) {
		final Result result = jobSeekerExperienceService.add(jobSeekerExperience);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerExperience jobSeekerExperience) {
		final Result result = jobSeekerExperienceService.delete(jobSeekerExperience);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerExperience>>> getAll() {
		final DataResult<List<JobSeekerExperience>> result = jobSeekerExperienceService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekerid")
	public ResponseEntity<DataResult<List<JobSeekerExperience>>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<List<JobSeekerExperience>> result = jobSeekerExperienceService
				.getAllByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekeridorderbyquitdate")
	public ResponseEntity<DataResult<List<JobSeekerExperience>>> getAllByJobSeeker_IdOrderByQuitDate(
			@RequestParam final int jobSeekerId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerExperience>> result = jobSeekerExperienceService
				.getAllByJobSeeker_IdOrderByQuitDate(jobSeekerId, direction);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerExperience jobSeekerExperience) {
		final Result result = jobSeekerExperienceService.update(jobSeekerExperience);

		return ResponseEntity.ok(result);
	}
}
