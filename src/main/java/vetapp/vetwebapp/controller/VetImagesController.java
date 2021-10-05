package vetapp.vetwebapp.controller;

import java.util.List;
import java.util.Optional;

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
import vetapp.vetwebapp.entities.Vet;
import vetapp.vetwebapp.entities.images.VetImage;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.VetImageService;
import vetapp.vetwebapp.service.abstracts.VetService;

@RestController
@RequestMapping("/v1/vet-images")
@CrossOrigin
public class VetImagesController {
	
	@Autowired
	private VetImageService vetImageService;
	@Autowired
	private VetService vetService;
	
	/*Result upload (int vetId,VetImage vetImage,MultipartFile file);
	DataResult<List<VetImage>> getAll();
	Result deleteById(int id);
	
	DataResult<List<VetImage>> getByVetId(int id);*/
	
	@PostMapping("/upload/")
	public Result add(@RequestParam(value = "id") int id, @RequestPart MultipartFile imageFile) {
		Vet vet= this.vetService.getById(id).getData();
		VetImage vetImage = new VetImage();
		vetImage.setVet(vet);
		try {
			return this.vetImageService.upload(id,vetImage, imageFile);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
		
	}
	
	@DeleteMapping("/vet-image/")
	public Result deleteById(int id) {
		return this.vetImageService.deleteById(id);
	}
	
	@GetMapping("/")
	public DataResult<List<VetImage>> getAll(){
		return this.vetImageService.getAll();
	}
	
	@GetMapping(value="/vet-image/")
	public DataResult<List<VetImage>> getByCarId(@RequestParam int id) {
		return this.vetImageService.getByVetId(id);
	}
	
	
}
