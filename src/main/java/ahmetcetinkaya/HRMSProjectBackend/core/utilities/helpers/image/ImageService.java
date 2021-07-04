package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image;

import org.springframework.web.multipart.MultipartFile;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<?> save(MultipartFile file);

	DataResult<?> delete(String id);
}
