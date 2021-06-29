package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeeker;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobSeekerForRegisterDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController extends BaseController<JobSeekerService, JobSeeker, Integer> {
    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(final JobSeekerService jobSeekerService) {
        super(jobSeekerService);
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Result> register(@Valid @RequestBody final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
        final Result result = jobSeekerService.register(jobSeekerForRegisterDto);

        if (!result.isSuccess())
            return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }
}
