package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmployerService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employers")
public class EmployersController extends BaseController<EmployerService, Employer, Integer> {
    private final EmployerService employerService;

    @Autowired
    public EmployersController(final EmployerService employerService) {
        super(employerService);
        this.employerService = employerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Result> register(@Valid @RequestBody final EmployerForRegisterDto employerForRegisterDto) {
        final Result result = employerService.register(employerForRegisterDto);

        if (!result.isSuccess())
            return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }

}
