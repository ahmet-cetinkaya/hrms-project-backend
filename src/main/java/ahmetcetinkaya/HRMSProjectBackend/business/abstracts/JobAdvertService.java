package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobAdvert;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto;
import java.util.List;

public interface JobAdvertService extends BaseService<JobAdvert, Integer> {
    Result verifyById(int id);

    DataResult<List<JobAdvert>> getAllByIsActive(boolean isActive);

    DataResult<List<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
                                                                                         String companyName);

    DataResult<List<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive);

    DataResult<List<JobAdvertForListDto>> getAllByIsActiveOrderByCreatedAtByForList(boolean isActive, String sort);
}
