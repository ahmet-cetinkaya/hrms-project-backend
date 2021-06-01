package ahmetcetinkaya.HRMSProjectBackend.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.core.business.BaseService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerImage;

public interface JobSeekerImageService extends BaseService<JobSeekerImage, Integer> {
	Result addAndSave(JobSeekerImage jobSeekerImage, MultipartFile file);

	DataResult<List<JobSeekerImage>> getAllByJobSeeker_Id(int jobSeekerId);
}
