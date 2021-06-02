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

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVImage;

@RestController
@RequestMapping("/api/jobseekers/cvs/images")
public class JobSeekerCVImagesController {
	private JobSeekerCVImageService jobSeekerCVImageService;

	@Autowired
	public JobSeekerCVImagesController(final JobSeekerCVImageService jobSeekerCVImageService) {
		this.jobSeekerCVImageService = jobSeekerCVImageService;
	}

	@PostMapping("/addandsave")
	public ResponseEntity<Result> addAndSave(@RequestParam final int jobSeekerCVId,
			@RequestBody final MultipartFile file) {
		final Result result = jobSeekerCVImageService.addAndSave(
				JobSeekerCVImage.builder().jobSeekerCV(JobSeekerCV.builder().id(jobSeekerCVId).build()).build(),
				file);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVImage jobSeekerCVImage) {
		final Result result = jobSeekerCVImageService.delete(jobSeekerCVImage);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerCVImage>>> getAll() {
		final DataResult<List<JobSeekerCVImage>> result = jobSeekerCVImageService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVImage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVImage>> result = jobSeekerCVImageService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
