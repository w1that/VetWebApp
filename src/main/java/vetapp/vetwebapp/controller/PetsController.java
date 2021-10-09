package vetapp.vetwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
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
	
	@GetMapping("/pets/genus/")
	public DataResult<List<Pet>> getByGenusId(@RequestParam int id){
		return this.petService.getByGenusId(id);
	}
	
	@GetMapping("/pets/pet/owner")
	public DataResult<List<Pet>> getByOwnerId(@RequestParam int id){
		return this.petService.getByOwnerId(id);
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
	public Result add(@RequestParam String disease, @RequestParam String description, @RequestParam int age, 
			@RequestParam int genusId, @RequestParam int ownerId) {
		return this.petService.add(disease,description, age, genusId, ownerId);
	}
	
}
