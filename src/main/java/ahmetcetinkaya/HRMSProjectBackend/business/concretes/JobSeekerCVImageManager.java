package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.ImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVImageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVImage;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class JobSeekerCVImageManager extends BaseManager<JobSeekerCVImageDao, JobSeekerCVImage, Integer> implements JobSeekerCVImageService {
    private final JobSeekerCVImageDao jobSeekerCVImageDao;
    private final ImageService imageService;

    @Autowired
    public JobSeekerCVImageManager(final JobSeekerCVImageDao jobSeekerCVImageDao, final ImageService imageService) {
        super(jobSeekerCVImageDao, "Job seeker CV image");
        this.jobSeekerCVImageDao = jobSeekerCVImageDao;
        this.imageService = imageService;
    }

    @Override
    public Result addAndSave(final JobSeekerCVImage jobSeekerCVImage, final MultipartFile file) {
        final Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        jobSeekerCVImage.setUrl(result.get("url"));

        return super.add(jobSeekerCVImage);
    }

    @Override
    public DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
        final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

        return new SuccessDataResult<List<JobSeekerCVImage>>(jobSeekerCVImages);
    }

}
