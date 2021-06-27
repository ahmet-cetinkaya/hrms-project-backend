package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVEducationService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVEducation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobseekers/cvs/educations")
public class JobSeekerCVEducationsController {
    private final JobSeekerCVEducationService jobSeekerCVEducationService;

    @Autowired
    public JobSeekerCVEducationsController(final JobSeekerCVEducationService jobSeekerCVEducationService) {
        this.jobSeekerCVEducationService = jobSeekerCVEducationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVEducation jobSeekerCVEducation) {
        final Result result = jobSeekerCVEducationService.add(jobSeekerCVEducation);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVEducation jobSeekerCVEducation) {
        final Result result = jobSeekerCVEducationService.delete(jobSeekerCVEducation);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAll() {
        final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/byjobseekercvid")
    public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
                .getAllByJobSeekerCV_Id(jobSeekerCVId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/byjobseekercvidorderbygraduationdate")
    public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_IdOrderByGraduationDate(
            @RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
        final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
                .getAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId, direction);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVEducation jobSeekerCVEducation) {
        final Result result = jobSeekerCVEducationService.update(jobSeekerCVEducation);

        return ResponseEntity.ok(result);
    }

}
