package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVWebSiteService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVWebSite;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobseekers/cvs/websites")
public class JobSeekerCVWebSitesController {
    private final JobSeekerCVWebSiteService jobSeekerCVWebSiteService;

    @Autowired
    public JobSeekerCVWebSitesController(final JobSeekerCVWebSiteService jobSeekerCVWebSiteService) {
        this.jobSeekerCVWebSiteService = jobSeekerCVWebSiteService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVWebSite jobSeekerCVWebSite) {
        final Result result = jobSeekerCVWebSiteService.add(jobSeekerCVWebSite);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVWebSite jobSeekerCVWebSite) {
        final Result result = jobSeekerCVWebSiteService.delete(jobSeekerCVWebSite);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAll() {
        final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/byjobseekercvid")
    public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService
                .getAllByJobSeekerCV_Id(jobSeekerCVId);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVWebSite jobSeekerCVWebSite) {
        final Result result = jobSeekerCVWebSiteService.update(jobSeekerCVWebSite);

        return ResponseEntity.ok(result);
    }
}
