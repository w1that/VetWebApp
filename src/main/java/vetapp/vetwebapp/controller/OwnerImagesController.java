package vetapp.vetwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.Owner;
import vetapp.vetwebapp.entities.Pet;
import vetapp.vetwebapp.entities.images.OwnerImage;
import vetapp.vetwebapp.entities.images.PetImage;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.OwnerImageService;
import vetapp.vetwebapp.service.abstracts.OwnerService;

@RestController
@CrossOrigin
@RequestMapping("/v1/owner-images/")
public class OwnerImagesController {

	@Autowired
	private OwnerService ownerService;
	@Autowired
	private OwnerImageService ownerImageService;
	
	@PostMapping("/upload/")
	public Result add(@RequestParam(value = "id") int id, @RequestPart MultipartFile imageFile) {
		Owner owner= this.ownerService.getById(id).getData();
		OwnerImage ownerImage = new OwnerImage();
		ownerImage.setOwner(owner);
		try {
			return this.ownerImageService.upload(id,ownerImage, imageFile);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}
	
	@DeleteMapping("/owner-image")
	public Result deleteById(int id) {
		return this.ownerImageService.deleteById(id);
	}
	
	@GetMapping("/")
	public DataResult<List<OwnerImage>> getAll(){
		return this.ownerImageService.getAll();
	}
	
	@GetMapping(value="/owner-image")
	public DataResult<List<OwnerImage>> getByCarId(@RequestParam int id) {
		return this.ownerImageService.getByOwnerId(id);
	}
	

}
