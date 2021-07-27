package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Image;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.ImageService;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.*;

@Service
public class CloudinaryImageManager implements ImageService {
	private final Cloudinary cloudinary;

	@Autowired
	public CloudinaryImageManager(final Environment environment) {
		cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name",
				environment.getProperty("cloudinary.cloud.name"),
				"api_key",
				environment.getProperty("cloudinary.api.key"),
				"api_secret",
				environment.getProperty("cloudinary.api.secret")));
	}

	@Override
	public DataResult<Image> save(final MultipartFile file) {
		final Map result;
		try {
			result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<>(e.getMessage());
		}

		Image image = Image.builder()
				.id(String.valueOf(result.get("public_id")))
				.url(String.valueOf(result.get("url")))
				.bytes(Integer.parseInt(String.valueOf(result.get("bytes"))))
				.format(String.valueOf(result.get("format")))
				.height(Integer.parseInt(String.valueOf(result.get("height"))))
				.width(Integer.parseInt(String.valueOf(result.get("width"))))
				.build();

		return new SuccessDataResult<>(image);
	}

	@Override
	public Result delete(final String id) {
		try {
			cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
		} catch (final IOException e) {
			e.printStackTrace();
			return new ErrorResult(e.getMessage());
		}

		return new SuccessResult();
	}
}
