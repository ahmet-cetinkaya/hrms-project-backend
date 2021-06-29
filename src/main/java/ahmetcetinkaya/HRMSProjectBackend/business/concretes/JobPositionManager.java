package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobPositionService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.business.BusinessRules;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobPositionDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPositionManager extends BaseManager<JobPositionDao, JobPosition, Integer> implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(final JobPositionDao jobPositionDao) {
        super(jobPositionDao, "Job position");
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
    public Result isNotExistsJobPosition(final String title) {
        return jobPositionDao.findByTitle(title).isEmpty() ? new SuccessResult()
                : new ErrorResult(Messages.jobPositionWithTitleAlreadyExits);
    }
}
