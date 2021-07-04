package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.CompanyStaffDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaff;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.CompanyStaffForUpdateDto;

@Service
public class CompanyStaffManager extends BaseManager<CompanyStaffDao, CompanyStaff, Integer>
		implements CompanyStaffService {
	private final CompanyStaffDao companyStaffDao;

	@Autowired
	public CompanyStaffManager(final CompanyStaffDao companyStaffDao) {
		super(companyStaffDao, "Company staff");
		this.companyStaffDao = companyStaffDao;
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}

	@Override
	public Result updateByUser(final CompanyStaffForUpdateDto companyStaffForUpdateDto) {
		final Optional<CompanyStaff> companyStaff = companyStaffDao.findById(companyStaffForUpdateDto.getId());
		if (companyStaff.isEmpty())
			return new ErrorResult(Messages.notFound("Company staff"));

		final Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(companyStaff.get().getPassword(), companyStaffForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		companyStaff.get().setFirstName(companyStaffForUpdateDto.getFirstName());
		companyStaff.get().setLastName(companyStaffForUpdateDto.getLastName());
		companyStaffDao.save(companyStaff.get());

		return new SuccessResult(Messages.updated("Company Staff"));
	}
}
