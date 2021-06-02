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

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerSkillService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerSkill;

@RestController
@RequestMapping("/api/jobseekers/skills")
public class JobSeekerSkillsController {
	private JobSeekerSkillService jobSeekerSkillService;

	@Autowired
	public JobSeekerSkillsController(final JobSeekerSkillService jobSeekerSkillService) {
		this.jobSeekerSkillService = jobSeekerSkillService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerSkill jobSeekerSkill) {
		final Result result = jobSeekerSkillService.add(jobSeekerSkill);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerSkill jobSeekerSkill) {
		final Result result = jobSeekerSkillService.delete(jobSeekerSkill);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerSkill>>> getAll() {
		final DataResult<List<JobSeekerSkill>> result = jobSeekerSkillService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byjobseekerid")
	public ResponseEntity<DataResult<List<JobSeekerSkill>>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<List<JobSeekerSkill>> result = jobSeekerSkillService.getAllByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byid")
	public ResponseEntity<DataResult<JobSeekerSkill>> getById(final int id) {
		final DataResult<JobSeekerSkill> result = jobSeekerSkillService.getById(id);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerSkill jobSeekerSkill) {
		final Result result = jobSeekerSkillService.update(jobSeekerSkill);

		return ResponseEntity.ok(result);
	}
}
