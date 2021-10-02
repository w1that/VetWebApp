package vetapp.vetwebapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import vetapp.vetwebapp.entities.Genus;
import vetapp.vetwebapp.service.abstracts.GenusService;

@RestController
@RequestMapping("/api/genuses")
public class GenusesController {
	
	@Autowired
	private GenusService genusService;
	
	@GetMapping("/")
	public List<Genus> getAll(){
		return this.genusService.getAll();
	}
	
	@GetMapping("/genus")
	public Optional<Genus> getById(@RequestParam int id){
		return this.genusService.getById(id);
	}
	
	@PostMapping("/")
	public void add(@RequestBody Genus genus) {
		this.genusService.add(genus);
	}
	
	@DeleteMapping("/")
	public void deleteAll() {
		this.genusService.deleteAll();
	}
	
	@DeleteMapping("/genus")
	public void deleteById(@RequestParam int id) {
		this.genusService.deleteById(id);
	}

}
