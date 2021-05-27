package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffVerificationService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;

@RestController
@RequestMapping("/api/companystaffverifications")
public class CompanyStaffVerificationController {
	private final CompanyStaffVerificationService companyStaffVerificationService;

	@Autowired
	public CompanyStaffVerificationController(final CompanyStaffVerificationService companyStaffVerificationService) {
		this.companyStaffVerificationService = companyStaffVerificationService;
	}

	@GetMapping("/verify")
	public ResponseEntity<Result> verify(final int id) {
		final Result result = companyStaffVerificationService.verify(id);

		if (!result.isSuccess())
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
