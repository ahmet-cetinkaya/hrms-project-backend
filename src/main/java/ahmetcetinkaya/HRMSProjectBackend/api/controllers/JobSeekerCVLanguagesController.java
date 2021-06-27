package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVLanguageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVLanguage;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobseekers/cvs/languages")
public class JobSeekerCVLanguagesController {
    private final JobSeekerCVLanguageService jobSeekerCVLanguageService;

    @Autowired
    public JobSeekerCVLanguagesController(final JobSeekerCVLanguageService jobSeekerCVLanguageService) {
        this.jobSeekerCVLanguageService = jobSeekerCVLanguageService;
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVLanguage jobSeekerCVLanguage) {
        final Result result = jobSeekerCVLanguageService.add(jobSeekerCVLanguage);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVLanguage jobSeekerCVLanguage) {
        final Result result = jobSeekerCVLanguageService.delete(jobSeekerCVLanguage);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAll() {
        final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService.getAll();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/getall/byjobseekercvid")
    public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService
                .getAllByJobSeekerCV_Id(jobSeekerCVId);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/byid")
    public ResponseEntity<DataResult<JobSeekerCVLanguage>> getbyid(final int id) {
        final DataResult<JobSeekerCVLanguage> result = jobSeekerCVLanguageService.getById(id);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/update")
    public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVLanguage jobSeekerCVLanguage) {
        final Result result = jobSeekerCVLanguageService.update(jobSeekerCVLanguage);

        return ResponseEntity.ok(result);
    }
}
