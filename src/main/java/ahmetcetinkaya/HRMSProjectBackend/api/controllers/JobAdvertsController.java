package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobAdvertService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobAdvert;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController extends BaseController<JobAdvertService, JobAdvert, Integer> {
    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(final JobAdvertService jobAdvertService) {
        super(jobAdvertService);
        this.jobAdvertService = jobAdvertService;
    }

    @PutMapping("/verify/byid")
    public ResponseEntity<Result> verifyById(final int id) {
        final Result result = jobAdvertService.verifyById(id);

        if (!result.isSuccess())
            return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }


    @GetMapping("/byisactive")
    public ResponseEntity<DataResult<List<JobAdvert>>> getAllByIsActive(final boolean isActive) {
        final DataResult<List<JobAdvert>> result = jobAdvertService.getAllByIsActive(isActive);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/forlist/byisactiveandemployercompanyname")
    public ResponseEntity<DataResult<List<JobAdvertForListDto>>> getAllByIsActiveAndEmployer_CompanyNameForList(
            @RequestParam final boolean isActive, @RequestParam final String companyName) {
        final DataResult<List<JobAdvertForListDto>> result = jobAdvertService
                .getAllByIsActiveAndEmployer_CompanyNameForList(isActive, companyName);

        if (!result.isSuccess())
            return new ResponseEntity<DataResult<List<JobAdvertForListDto>>>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/forlist/byisactive")
    public ResponseEntity<DataResult<List<JobAdvertForListDto>>> getAllByIsActiveForList(
            @RequestParam final boolean isActive) {
        final DataResult<List<JobAdvertForListDto>> result = jobAdvertService.getAllByIsActiveForList(isActive);

        if (!result.isSuccess())
            return new ResponseEntity<DataResult<List<JobAdvertForListDto>>>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/forlist/byisactiveorderbycreatedatby")
    public ResponseEntity<DataResult<List<JobAdvertForListDto>>> getAllByIsActiveOrderByCreatedAtByForList(
            @RequestParam final boolean isActive, @RequestParam final String direction) {
        final DataResult<List<JobAdvertForListDto>> result = jobAdvertService
                .getAllByIsActiveOrderByCreatedAtByForList(isActive, direction);

        if (!result.isSuccess())
            return new ResponseEntity<DataResult<List<JobAdvertForListDto>>>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }
}
