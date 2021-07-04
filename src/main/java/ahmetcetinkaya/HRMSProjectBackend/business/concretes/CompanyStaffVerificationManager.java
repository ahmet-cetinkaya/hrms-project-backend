package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffVerificationService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.CompanyStaffVerificationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager
		extends BaseManager<CompanyStaffVerificationDao, CompanyStaffVerification, Integer>
		implements CompanyStaffVerificationService {
	private final CompanyStaffVerificationDao companyStaffVerificationDao;

	@Autowired
	public CompanyStaffVerificationManager(final CompanyStaffVerificationDao companyStaffVerificationDao) {
		super(companyStaffVerificationDao, "Company staff verification");
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}

	@Override
	public DataResult<CompanyStaffVerification> getByUserId(final int userId) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao
				.findByUser_Id(userId);

		if (companyStaffVerification.isEmpty())
			return new ErrorDataResult<>(Messages.notFound("Company staff verification"));

		return new SuccessDataResult<>(companyStaffVerification.get());
	}

	@Override
	public Result verify(final int userId) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getByUserId(userId);

		if (!companyStaffVerification.isSuccess())
			return new ErrorResult(Messages.notFound("Company staff verification"));

		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());

		return new SuccessResult(Messages.verified("User"));
	}

}
