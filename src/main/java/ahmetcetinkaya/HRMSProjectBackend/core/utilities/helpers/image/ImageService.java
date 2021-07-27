package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.core.entities.Image;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.Result;

public interface ImageService {
	DataResult<Image> save(MultipartFile file);

	Result delete(String id);
}
