package vetapp.vetwebapp.service.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.VetImage;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface VetImageService {
	Result upload (int vetId,VetImage vetImage,MultipartFile file);
	DataResult<List<VetImage>> getAll();
	Result deleteById(int id);
	
	DataResult<List<VetImage>> getByVetId(int id);
}
