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

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVSkillService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVSkill;

@RestController
@RequestMapping("/api/jobseekers/cvs/skills")
public class JobSeekerCVSkillsController {
	private JobSeekerCVSkillService jobSeekerCVSkillService;

	@Autowired
	public JobSeekerCVSkillsController(final JobSeekerCVSkillService jobSeekerCVSkillService) {
		this.jobSeekerCVSkillService = jobSeekerCVSkillService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVSkill jobSeekerCVSkill) {
		final Result result = jobSeekerCVSkillService.add(jobSeekerCVSkill);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVSkill jobSeekerCVSkill) {
		final Result result = jobSeekerCVSkillService.delete(jobSeekerCVSkill);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerCVSkill>>> getAll() {
		final DataResult<List<JobSeekerCVSkill>> result = jobSeekerCVSkillService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVSkill>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVSkill>> result = jobSeekerCVSkillService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byid")
	public ResponseEntity<DataResult<JobSeekerCVSkill>> getById(final int id) {
		final DataResult<JobSeekerCVSkill> result = jobSeekerCVSkillService.getById(id);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVSkill jobSeekerCVSkill) {
		final Result result = jobSeekerCVSkillService.update(jobSeekerCVSkill);

		return ResponseEntity.ok(result);
	}
}
