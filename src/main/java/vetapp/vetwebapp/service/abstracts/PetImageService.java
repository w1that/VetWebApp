package vetapp.vetwebapp.service.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.PetImage;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface PetImageService {
	Result upload (int petId,PetImage petImage,MultipartFile file);
	DataResult<List<PetImage>> getAll();
	Result deleteById(int id);
	
	DataResult<List<PetImage>> getByPetId(int id);
}
