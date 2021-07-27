package ahmetcetinkaya.HRMSProjectBackend.core.utilities.helpers.image.cloudinary;

public class CloudinaryImageHelper {
	public static String getImagePublicIdFromUrl(final String url) {
		return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
	}
}
