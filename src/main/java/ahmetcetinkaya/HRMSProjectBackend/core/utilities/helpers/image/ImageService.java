package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image;

import ahmetcetinkaya.HRMSProjectBackend.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    DataResult<?> save(MultipartFile file);
}
