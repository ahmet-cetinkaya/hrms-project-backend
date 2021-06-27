package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobPositionService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobPositionDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobPosition;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(final JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Result add(final JobPosition jobPosition) {
        final Result businessRulesResult = BusinessRules.run(isNotExistsJobPosition(jobPosition.getTitle()));
        if (!businessRulesResult.isSuccess())
            return businessRulesResult;

        jobPositionDao.save(jobPosition);

        return new SuccessResult(Messages.jobPositionAdded);
    }

    @Override
    public Result delete(final JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);

        return new SuccessResult(Messages.jobPositionDeleted);
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        final List<JobPosition> jobPositions = jobPositionDao.findAll();

        return new SuccessDataResult<List<JobPosition>>(jobPositions);
    }

    @Override
    public DataResult<JobPosition> getById(final Integer id) {
        final Optional<JobPosition> jobPosition = jobPositionDao.findById(id);

        if (jobPosition.isEmpty())
            return new ErrorDataResult<JobPosition>(Messages.jobPositionNotFound);

        return new SuccessDataResult<JobPosition>(jobPosition.get());
    }

    @Override
    public Result isNotExistsJobPosition(final String title) {
        return jobPositionDao.findByTitle(title).isEmpty() ? new SuccessResult()
                : new ErrorResult(Messages.jobPositionWithTitleAlreadyExits);
    }

    @Override
    public Result update(final JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);

        return new SuccessResult(Messages.jobPositionUpdated);
    }

}
