package vetapp.vetwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vetapp.vetwebapp.entities.Owner;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.service.abstracts.OwnerService;

@RestController
@RequestMapping("/v1/owners")
@CrossOrigin
public class OwnersController {
	
	@Autowired
	private OwnerService ownerService;
	
	@GetMapping("/")
	public DataResult<List<Owner>> getAll(){
		return this.ownerService.getAll();
	}
	
	@GetMapping("/owner")
	public DataResult<Owner> getById(@RequestParam int id){
		return this.ownerService.getById(id);
	}
	
	@GetMapping("/owner/email/")
	public DataResult<Owner> getByEmail(@RequestParam String email){
		return this.ownerService.getByEmail(email);
	}
	
	@GetMapping("/owner/username/")
	public DataResult<Owner> getByUsername(@RequestParam String username){
		return this.ownerService.getByUsername(username);
	}
	
	@PostMapping("/")
	public Result add(@RequestParam String username, @RequestParam String password, @RequestParam String email,@RequestParam String latitude,@RequestParam String longitude, @RequestParam String firstName, @RequestParam String lastName) {
		return this.ownerService.add(username, password, email, latitude, longitude, firstName, lastName);
	}
	
 	
	@PutMapping("/owner/premium/")
	public Result setPremium(@RequestParam int id) {
		return this.ownerService.setPremium(id);
	}
	
	@PutMapping("/owner/normal/")
	public Result setNotPremium(@RequestParam int id) {
		return this.ownerService.setNotPremium(id);
	}
}
