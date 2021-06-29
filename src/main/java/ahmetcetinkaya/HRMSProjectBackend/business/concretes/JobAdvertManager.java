package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobAdvertService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobAdvertDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobAdvert;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobAdvertManager extends BaseManager<JobAdvertDao, JobAdvert, Integer> implements JobAdvertService {
    private final JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(final JobAdvertDao jobAdvertDao) {
        super(jobAdvertDao, "Job advert");
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result verifyById(final int id) {
        final Optional<JobAdvert> jobAdvert = jobAdvertDao.findById(id);

        if (jobAdvert.isEmpty())
            return new ErrorDataResult<JobAdvert>(Messages.jobAdvertNotFound);

        jobAdvert.get().setActive(true);

        return super.update(jobAdvert.get());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllByIsActive(final boolean isActive) {
        final List<JobAdvert> jobAdverts = jobAdvertDao.findAllByIsActive(isActive);

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
}
