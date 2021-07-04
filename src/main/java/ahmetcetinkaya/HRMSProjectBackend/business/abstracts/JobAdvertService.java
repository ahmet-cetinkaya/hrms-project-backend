package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobAdvert;
import ahmetcetinkaya.HRMSProjectBackend.entities.dtos.JobAdvertForListDto;

public interface JobAdvertService extends BaseService<JobAdvert, Integer> {
	Result verifyById(int id);

	DataResult<Page<JobAdvert>> getAllByIsActive(boolean isActive, int page, int size, String[] sortProperties,
			Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName, int page, int size, String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive, int page, int size,
			String[] sortProperties, Sort.Direction sortDirection);

	DataResult<Page<JobAdvertForListDto>> getAllByIsActiveAndCityAndWorkingTimeForList(boolean isActive, short cityId,
			short workingTimeId, int page, int size, String[] sortProperties, Sort.Direction sortDirection);
}
