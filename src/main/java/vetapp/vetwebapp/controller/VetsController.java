package vetapp.vetwebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import vetapp.vetwebapp.entities.Vet;
import vetapp.vetwebapp.service.abstracts.VetService;

@RestController
@RequestMapping("/v1/vets")
public class VetsController {

	@Autowired
	private VetService vetService;
	
	
	@GetMapping("/")
	List<Vet> getAll(){
		return this.vetService.getAll();
	}
	
	@GetMapping("/vet")
	Optional<Vet> getById(@RequestParam int id){
		return this.vetService.getById(id);
	}
	
	@GetMapping("/getByClinicNameLike")
	List<Vet> getByClinicNameLike(String like){
		return this.vetService.getByClinicNameLike(like);
	}
	
	@GetMapping("/getByClinicNameContaining")
	List<Vet> getByClinicNameContaining(String containing){
		return this.vetService.getByClinicNameContaining(containing);
	}
	
	@GetMapping("getActives")
	List<Vet> getByIsActiveTrue(){
		return this.vetService.getByIsActiveTrue();
	}
	
	@PostMapping("/")
	void add(@RequestBody Vet vet) {
		this.vetService.add(vet);
	}
	
	@PutMapping("/")
	void setActive(int vetId) {
		this.vetService.setActive(vetId);
	}
	
	@DeleteMapping("/")
	void deleteAll() {
		this.vetService.deleteAll();
	}
	
	@DeleteMapping("/vet")
	void deleteById(int id) {
		this.vetService.deleteById(id);
	}
	
	
}
