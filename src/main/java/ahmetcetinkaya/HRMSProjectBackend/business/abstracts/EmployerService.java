package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.Employer;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.EmployerUpdate;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForRegisterDto;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.EmployerForUpdateDto;

public interface EmployerService extends BaseService<Employer, Integer> {
	DataResult<EmployerUpdate> getLastUpdateByUserId(int employerId);

	DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted);

	Result isNotCorporateEmailExist(String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);

	Result updateByUser(EmployerForUpdateDto employerForUpdateDto, MultipartFile companyImage);

	Result verifyUpdate(int employerUpdateId);

	Result denyUpdate(final int employerUpdateId);
}
