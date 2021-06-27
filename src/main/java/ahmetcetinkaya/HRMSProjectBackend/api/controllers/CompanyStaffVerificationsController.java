package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffVerificationService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companystaffverifications")
public class CompanyStaffVerificationsController {
    private final CompanyStaffVerificationService companyStaffVerificationService;

    @Autowired
    public CompanyStaffVerificationsController(final CompanyStaffVerificationService companyStaffVerificationService) {
        this.companyStaffVerificationService = companyStaffVerificationService;
    }

    @GetMapping("/verify")
    public ResponseEntity<Result> verify(@RequestParam final int userId) {
        final Result result = companyStaffVerificationService.verify(userId);

        if (!result.isSuccess())
            return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(result);
    }
}
