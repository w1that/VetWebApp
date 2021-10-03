package vetapp.vetwebapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vetapp.vetwebapp.entities.Pet;
import vetapp.vetwebapp.entities.images.PetImage;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.PetImageService;
import vetapp.vetwebapp.service.abstracts.PetService;

@RestController
@RequestMapping("/v1/pet-images/")
public class PetImagesController {
	@Autowired
	private PetImageService petImageService;
	@Autowired
	private PetService petService;
	
	@PostMapping("/upload/")
	public Result add(@RequestParam(value = "id") int id, @RequestPart MultipartFile imageFile) {
		Pet pet= this.petService.getById(id).getData();
		PetImage petImage = new PetImage();
		petImage.setPet(pet);
		try {
			return this.petImageService.upload(id,petImage, imageFile);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}
	
	@DeleteMapping("/pet")
	public Result deleteById(int id) {
		return this.petImageService.deleteById(id);
	}
	
	@GetMapping("/")
	public DataResult<List<PetImage>> getAll(){
		return this.petImageService.getAll();
	}
	
	@GetMapping(value="/pet")
	public DataResult<List<PetImage>> getByCarId(@RequestParam int id) {
		return this.petImageService.getByPetId(id);
	}
	
}
