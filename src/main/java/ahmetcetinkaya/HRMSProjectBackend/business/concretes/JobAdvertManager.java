package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobAdvertService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobAdvertDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobAdvert;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto;

@Service
public class JobAdvertManager implements JobAdvertService {
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(final JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(final JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);

		return new SuccessResult(Messages.JobAdvertAdded);
	}

	@Override
	public Result delete(final JobAdvert jobAdvert) {
		jobAdvertDao.delete(jobAdvert);

		return new SuccessResult(Messages.JobAdvertDeleted);
	}

	@Override
	public Result disableById(final int id) {
		final Optional<JobAdvert> jobAdvert = jobAdvertDao.findById(id);

		if (jobAdvert.isEmpty())
			return new ErrorDataResult<JobAdvert>(Messages.JobAdvertNotFound);

		jobAdvert.get().setActive(false);

		return update(jobAdvert.get());
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		final List<JobAdvert> jobAdverts = jobAdvertDao.findAll();

		return new SuccessDataResult<List<JobAdvert>>(jobAdverts);
	}

	@Override
	public DataResult<List<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(final boolean isActive,
			final String companyName) {
		final List<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao
				.findAllByIsActiveAndEmployer_CompanyNameForList(isActive, companyName);

		return new SuccessDataResult<List<JobAdvertForListDto>>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<List<JobAdvertForListDto>> getAllByIsActiveForList(final boolean isActive) {
		final List<JobAdvertForListDto> jobAdvertForListDtos = jobAdvertDao.findAllByIsActiveForList(isActive);

		return new SuccessDataResult<List<JobAdvertForListDto>>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<List<JobAdvertForListDto>> getAllByIsActiveOrderByCreatedAtByForList(final boolean isActive,
			final String direction) {
		final List<JobAdvertForListDto> jobAdvertForListDtos = direction.equals("desc")
				? jobAdvertDao.findAllByIsActiveOrderByCreatedAtDescForList(isActive)
				: jobAdvertDao.findAllByIsActiveOrderByCreatedAtForList(isActive);

		return new SuccessDataResult<List<JobAdvertForListDto>>(jobAdvertForListDtos);
	}

	@Override
	public DataResult<JobAdvert> getById(final Integer id) {
		final Optional<JobAdvert> jobAdvert = jobAdvertDao.findById(id);

		if (jobAdvert.isEmpty())
			return new ErrorDataResult<JobAdvert>(Messages.JobAdvertNotFound);

		return new SuccessDataResult<JobAdvert>(jobAdvert.get());
	}

	@Override
	public Result update(final JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);

		return new SuccessResult(Messages.JobAdvertUpdated);
	}

}
