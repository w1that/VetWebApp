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
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.VetService;

@RestController
@RequestMapping("/v1/vets")
public class VetsController {

	@Autowired
	private VetService vetService;
	
	
	@GetMapping("/")
	DataResult<List<Vet>> getAll(){
		return this.vetService.getAll();
	}
	
	@GetMapping("/vet")
	DataResult<Vet> getById(@RequestParam int id){
		return this.vetService.getById(id);
	}
	
	@GetMapping("/getByClinicNameLike")
	DataResult<List<Vet>> getByClinicNameLike(String like){
		return this.vetService.getByClinicNameLike(like);
	}
	
	@GetMapping("/getByClinicNameContaining")
	DataResult<List<Vet>> getByClinicNameContaining(String containing){
		return this.vetService.getByClinicNameContaining(containing);
	}
	
	@GetMapping("getActives")
	DataResult<List<Vet>> getByIsActiveTrue(){
		return this.vetService.getByIsActiveTrue();
	}
	
	/*@PostMapping("/")
	Result add(@RequestBody Vet vet) {
		return this.vetService.add(vet);
	}*/
	
	@PostMapping("/")
	Result add(@RequestParam String username, @RequestParam String password, @RequestParam String clinicName,
			@RequestParam String email, @RequestParam String address) {
		
		return this.vetService.add(username, password, clinicName, email, address);
	}
	
	@PutMapping("/")
	Result setActive(int vetId) {
		return this.vetService.setActive(vetId);
	}
	
	@DeleteMapping("/")
	Result deleteAll() {
		return this.vetService.deleteAll();
	}
	
	@DeleteMapping("/vet")
	Result deleteById(int id) {
		return this.vetService.deleteById(id);
	}
	
	
}
