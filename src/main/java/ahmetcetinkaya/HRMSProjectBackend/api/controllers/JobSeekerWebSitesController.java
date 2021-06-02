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

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerWebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerWebSite;

@RestController
@RequestMapping("/api/jobseeker/websites")
public class JobSeekerWebSitesController {
	private JobSeekerWebSiteService jobSeekerWebSiteService;

	@Autowired
	public JobSeekerWebSitesController(final JobSeekerWebSiteService jobSeekerWebSiteService) {
		this.jobSeekerWebSiteService = jobSeekerWebSiteService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerWebSite jobSeekerWebSite) {
		final Result result = jobSeekerWebSiteService.add(jobSeekerWebSite);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerWebSite jobSeekerWebSite) {
		final Result result = jobSeekerWebSiteService.delete(jobSeekerWebSite);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerWebSite>>> getAll() {
		final DataResult<List<JobSeekerWebSite>> result = jobSeekerWebSiteService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekerid")
	public ResponseEntity<DataResult<List<JobSeekerWebSite>>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<List<JobSeekerWebSite>> result = jobSeekerWebSiteService.getAllByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerWebSite jobSeekerWebSite) {
		final Result result = jobSeekerWebSiteService.update(jobSeekerWebSite);

		return ResponseEntity.ok(result);
	}
}
