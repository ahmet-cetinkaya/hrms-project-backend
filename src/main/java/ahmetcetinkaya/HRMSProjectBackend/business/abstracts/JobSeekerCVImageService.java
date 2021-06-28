package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVImage;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface JobSeekerCVImageService extends BaseService<JobSeekerCVImage, Integer> {
    Result addAndSave(JobSeekerCVImage jobSeekerImage, MultipartFile file);

    DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
