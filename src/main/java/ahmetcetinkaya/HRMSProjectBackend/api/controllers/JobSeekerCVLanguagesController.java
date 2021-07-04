package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVLanguageService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVLanguage;

@RestController
@RequestMapping("/api/jobseekers/cvs/languages")
public class JobSeekerCVLanguagesController
		extends BaseController<JobSeekerCVLanguageService, JobSeekerCVLanguage, Integer> {
	private final JobSeekerCVLanguageService jobSeekerCVLanguageService;

	@Autowired
	public JobSeekerCVLanguagesController(final JobSeekerCVLanguageService jobSeekerCVLanguageService) {
		super(jobSeekerCVLanguageService);
		this.jobSeekerCVLanguageService = jobSeekerCVLanguageService;
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

}
