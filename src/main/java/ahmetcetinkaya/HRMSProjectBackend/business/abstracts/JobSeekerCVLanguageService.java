package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVLanguage;
import java.util.List;

public interface JobSeekerCVLanguageService extends BaseService<JobSeekerCVLanguage, Integer> {
    DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
