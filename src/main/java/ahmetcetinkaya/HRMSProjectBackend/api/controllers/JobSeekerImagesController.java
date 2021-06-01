package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeeker;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerImage;

@RestController
@RequestMapping("/api/jobseekers/images")
public class JobSeekerImagesController {
	private JobSeekerImageService jobSeekerImageService;

	@Autowired
	public JobSeekerImagesController(final JobSeekerImageService jobSeekerImageService) {
		this.jobSeekerImageService = jobSeekerImageService;
	}

	@PostMapping("/addandsave")
	public ResponseEntity<Result> addAndSave(@RequestParam final int jobSeekerId,
			@RequestBody final MultipartFile file) {
		final Result result = jobSeekerImageService.addAndSave(
				JobSeekerImage.builder().jobSeeker(JobSeeker.childBuilder().id(jobSeekerId).build()).build(),
				file);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerImage jobSeekerImage) {
		final Result result = jobSeekerImageService.delete(jobSeekerImage);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerImage>>> getAll() {
		final DataResult<List<JobSeekerImage>> result = jobSeekerImageService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekerid")
	public ResponseEntity<DataResult<List<JobSeekerImage>>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<List<JobSeekerImage>> result = jobSeekerImageService.getAllByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}
}
