package vetapp.vetwebapp.service.abstracts;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.OwnerImage;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface OwnerImageService {
	Result upload (int ownerId,OwnerImage ownerImage,MultipartFile file);
	DataResult<List<OwnerImage>> getAll();
	Result deleteById(int id);
	
	DataResult<List<OwnerImage>> getByOwnerId(int id);
}
