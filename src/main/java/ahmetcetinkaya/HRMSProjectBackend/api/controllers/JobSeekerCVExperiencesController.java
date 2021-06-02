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

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVExperienceService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVExperience;

@RestController
@RequestMapping("/api/jobseekers/cvs/experiences")
public class JobSeekerCVExperiencesController {
	private JobSeekerCVExperienceService jobSeekerCVExperienceService;

	@Autowired
	public JobSeekerCVExperiencesController(final JobSeekerCVExperienceService jobSeekerCVExperienceService) {
		this.jobSeekerCVExperienceService = jobSeekerCVExperienceService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVExperience jobSeekerCVExperience) {
		final Result result = jobSeekerCVExperienceService.add(jobSeekerCVExperience);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVExperience jobSeekerCVExperience) {
		final Result result = jobSeekerCVExperienceService.delete(jobSeekerCVExperience);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAll() {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvidorderbyquitdate")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAllByJobSeekerCV_IdOrderByQuitDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService
				.getAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVExperience jobSeekerCVExperience) {
		final Result result = jobSeekerCVExperienceService.update(jobSeekerCVExperience);

		return ResponseEntity.ok(result);
	}
}
