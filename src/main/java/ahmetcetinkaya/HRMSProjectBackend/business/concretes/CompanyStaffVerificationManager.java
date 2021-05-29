package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.CompanyStaffVerificationService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.CompanyStaffVerificationDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager implements CompanyStaffVerificationService {
	private final CompanyStaffVerificationDao companyStaffVerificationDao;

	@Autowired
	public CompanyStaffVerificationManager(final CompanyStaffVerificationDao companyStaffVerificationDao) {
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}

	@Override
	public Result add(final CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);

		return new SuccessResult(Messages.companyStaffVerificationAdded);
	}

	@Override
	public Result delete(final CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.delete(companyStaffVerification);

		return new SuccessResult(Messages.companyStaffVerificationDeleted);
	}

	@Override
	public DataResult<List<CompanyStaffVerification>> getAll() {
		final List<CompanyStaffVerification> companyStaffVerifications = companyStaffVerificationDao.findAll();

		return new SuccessDataResult<List<CompanyStaffVerification>>(companyStaffVerifications);
	}

	@Override
	public DataResult<CompanyStaffVerification> getById(final int id) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao.findById(id);

		if (companyStaffVerification.isEmpty())
			return new ErrorDataResult<CompanyStaffVerification>(Messages.companyStaffVerificationNotFound);

		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerification.get());
	}

	@Override
	public DataResult<CompanyStaffVerification> getByUserId(final int userId) {
		final Optional<CompanyStaffVerification> companyStaffVerification = companyStaffVerificationDao
				.findByUser_Id(userId);

		if (companyStaffVerification.isEmpty())
			return new ErrorDataResult<CompanyStaffVerification>(Messages.companyStaffVerificationNotFound);

		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerification.get());
	}

	@Override
	public Result update(final CompanyStaffVerification companyStaffVerification) {
		companyStaffVerificationDao.save(companyStaffVerification);

		return new SuccessResult(Messages.companyStaffVerificationUpdated);
	}

	@Override
	public Result verify(final int userId) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getByUserId(userId);

		if (!companyStaffVerification.isSuccess())
			return new ErrorResult(Messages.companyStaffVerificationNotFound);

		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());

		return new SuccessResult(Messages.companyStaffVerificationVerified);
	}

}
