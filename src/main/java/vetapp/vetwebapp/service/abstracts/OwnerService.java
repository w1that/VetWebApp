package vetapp.vetwebapp.service.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import vetapp.vetwebapp.entities.Owner;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface OwnerService {

	Result add(String username, String password, String email, String latitude, String longitude, String firstName, String lastName);
	
	DataResult<List<Owner>> getAll();
	DataResult<Owner> getById(int id);
	DataResult<Owner> getByEmail(String email);
	DataResult<Owner> getByUsername(String username);
	
	Result setPremium(int id);
	Result setNotPremium(int id);
	
	
}
