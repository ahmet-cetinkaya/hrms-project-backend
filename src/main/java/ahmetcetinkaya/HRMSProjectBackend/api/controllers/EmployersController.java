package ahmetcetinkaya.HRMSProjectBackend.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.EmployerService;
import ahmetcetinkaya.HRMSProjectBackend.core.api.abstracts.BaseController;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmployerUpdate;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForUpdateDto;

@RestController
@RequestMapping("/api/employers")
public class EmployersController extends BaseController<EmployerService, Employer, Integer> {
	private final EmployerService employerService;

	@Autowired
	public EmployersController(final EmployerService employerService) {
		super(employerService);
		this.employerService = employerService;
	}

	@GetMapping("/update/byuserid/last")
	public ResponseEntity<DataResult<EmployerUpdate>> getLastUpdateByUserId(@RequestParam final int employerId) {
		final DataResult<EmployerUpdate> result = employerService.getLastUpdateByUserId(employerId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/update/byisapprovedandisdeleted")
	public ResponseEntity<DataResult<List<EmployerUpdate>>> getAllByIsApprovedAndIsDeleted(
			@RequestParam final boolean isApproved,
			@RequestParam final boolean isDeleted) {
		final DataResult<List<EmployerUpdate>> result = employerService.getAllByIsApprovedAndIsDeleted(isApproved,
				isDeleted);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/register")
	public ResponseEntity<Result> register(@Valid @RequestBody final EmployerForRegisterDto employerForRegisterDto) {
		final Result result = employerService.register(employerForRegisterDto);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/byuser")
	public ResponseEntity<Result> updateByUser(@Valid @ModelAttribute EmployerForUpdateDto employerForUpdateDto,
			@RequestBody MultipartFile companyImage) {
		final Result result = employerService.updateByUser(employerForUpdateDto, companyImage);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PutMapping("/verify/update")
	public ResponseEntity<Result> verifyUpdate(@RequestParam final int employerUpdateId) {
		final Result result = employerService.verifyUpdate(employerUpdateId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

}
