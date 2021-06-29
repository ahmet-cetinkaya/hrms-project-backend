package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobseekers/cvs")
public class JobSeekerCVsController extends BaseController<JobSeekerCVService, JobSeekerCV, Integer> {
    private final JobSeekerCVService jobSeekerCVService;

    @Autowired
    public JobSeekerCVsController(final JobSeekerCVService jobSeekerCVService) {
        super(jobSeekerCVService);
        this.jobSeekerCVService = jobSeekerCVService;
    }
    
    @GetMapping("/byjobseekerid")
    public ResponseEntity<DataResult<JobSeekerCV>> getByJobSeeker_Id(final int jobSeekerId) {
        final DataResult<JobSeekerCV> result = jobSeekerCVService.getByJobSeeker_Id(jobSeekerId);

        return ResponseEntity.ok(result);
    }
}
