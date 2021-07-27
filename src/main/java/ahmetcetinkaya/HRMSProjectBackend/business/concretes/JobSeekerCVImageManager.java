package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerCVImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.business.abstracts.BaseManager;
import ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.entities.Image;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.ImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.cloudinary.CloudinaryImageHelper;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerCVImageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerCVImage;

@Service
public class JobSeekerCVImageManager extends BaseManager<JobSeekerCVImageDao, JobSeekerCVImage, Integer>
		implements JobSeekerCVImageService {
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
		final Image result = imageService.save(file).getData();
		jobSeekerCVImage.setUrl(result.getUrl());

		return super.add(jobSeekerCVImage);
	}

	@Override
	public Result delete(final Integer id) {
		final Optional<JobSeekerCVImage> jobSeekerCVImage = jobSeekerCVImageDao.findById(id);
		if (jobSeekerCVImage.isEmpty())
			return new ErrorDataResult<JobSeekerCVImage>(
					ahmetcetinkaya.HRMSProjectBackend.core.business.constants.Messages.deleted("Job seeker CV image"));

		final var imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(jobSeekerCVImage.get().getUrl());
		imageService.delete(imagePublicId);

		jobSeekerCVImageDao.delete(jobSeekerCVImage.get());
		return new SuccessResult(Messages.deleted("Job seeker CV Image"));
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVImage> jobSeekerCVImages = jobSeekerCVImageDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVImages);
	}
}