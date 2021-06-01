package ahmetcetinkaya.HRMSProjectBackend.business.concretes;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.business.abstracts.JobSeekerImageService;
import ahmetcetinkaya.HRMSProjectBackend.business.constants.Messages;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.ImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.ErrorDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessDataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.SuccessResult;
import ahmetcetinkaya.HRMSProjectBackend.dataAccess.abstracts.JobSeekerImageDao;
import ahmetcetinkaya.HRMSProjectBackend.entities.concretes.JobSeekerImage;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {
	private JobSeekerImageDao jobSeekerImageDao;
	private ImageService imageService;

	@Autowired
	public JobSeekerImageManager(final JobSeekerImageDao jobSeekerImageDao, final ImageService imageService) {
		this.jobSeekerImageDao = jobSeekerImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(final JobSeekerImage jobSeekerImage) {
		jobSeekerImageDao.save(jobSeekerImage);

		return new SuccessResult(Messages.JobSeekerImageAdded);
	}

	@Override
	public Result addAndSave(final JobSeekerImage jobSeekerImage, final MultipartFile file) {
		final Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		jobSeekerImage.setUrl(result.get("url"));

		return add(jobSeekerImage);
	}

	@Override
	public Result delete(final JobSeekerImage jobSeekerImage) {
		jobSeekerImageDao.delete(jobSeekerImage);

		return new SuccessResult(Messages.JobSeekerImageDeleted);
	}

	@Override
	public DataResult<List<JobSeekerImage>> getAll() {
		final List<JobSeekerImage> jobSeekerImages = jobSeekerImageDao.findAll();

		return new SuccessDataResult<List<JobSeekerImage>>(jobSeekerImages);
	}

	@Override
	public DataResult<List<JobSeekerImage>> getAllByJobSeeker_Id(final int jobSeekerId) {
		final List<JobSeekerImage> jobSeekerImages = jobSeekerImageDao.findAllByJobSeeker_Id(jobSeekerId);

		return new SuccessDataResult<List<JobSeekerImage>>(jobSeekerImages);
	}

	@Override
	public DataResult<JobSeekerImage> getById(final Integer id) {
		final Optional<JobSeekerImage> jobSeekerImage = jobSeekerImageDao.findById(id);

		if (jobSeekerImage.isEmpty())
			new ErrorDataResult<JobSeekerImage>(Messages.JobSeekerImageNotFound);

		return new SuccessDataResult<JobSeekerImage>(jobSeekerImage.get());
	}

	@Override
	public Result update(final JobSeekerImage jobSeekerImage) {
		jobSeekerImageDao.save(jobSeekerImage);

		return new SuccessResult(Messages.JobSeekerImageUpdated);
	}

}
