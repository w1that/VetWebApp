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
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.GenusService;

@RestController
@RequestMapping("/v1/genuses")
public class GenusesController {
	
	@Autowired
	private GenusService genusService;
	
	@GetMapping("/")
	public DataResult<List<Genus>> getAll(){
		return this.genusService.getAll();
	}
	
	
	@GetMapping("/genus")
	public DataResult<Genus> getById(@RequestParam int id){
		return this.genusService.getById(id);
	}
	
	@PostMapping("/")
	public Result add(@RequestBody Genus genus) {
		return this.genusService.add(genus);
	}
	
	@DeleteMapping("/")
	public Result deleteAll() {
		return this.genusService.deleteAll();
		
	}
	
	@DeleteMapping("/genus")
	public Result deleteById(@RequestParam int id) {
		return this.genusService.deleteById(id);
	}

}
