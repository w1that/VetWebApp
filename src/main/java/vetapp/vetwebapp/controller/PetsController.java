package vetapp.vetwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vetapp.vetwebapp.entities.Pet;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.PetService;

@RestController
@RequestMapping("/v1/pets")
public class PetsController {
	
	@Autowired
	private PetService petService;
	
	@GetMapping("/")
	public DataResult<List<Pet>> getAll() {
		return this.petService.getAll();
	}
	
	@GetMapping("/pet/")
	public DataResult<Pet> getById(@RequestParam int id){
		return this.petService.getById(id);
	}
	
	@DeleteMapping("/")
	public Result deleteAll() {
		return this.petService.deleteAll();
	}
	
	@DeleteMapping("/pet/")
	public Result deleteById(@RequestParam int id) {
		return this.petService.deleteById(id);
	}
	
	@PostMapping("/")
	public Result add(String disease, int age, int genusId, int ownerId) {
		return this.petService.add(disease, age, genusId, ownerId);
	}
	
}
