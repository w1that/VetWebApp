package vetapp.vetwebapp.utilities.imageUpload;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;
import vetapp.vetwebapp.results.DataResult;


public interface ImageUploadService {
	 DataResult<Map> upload(MultipartFile file);
}
