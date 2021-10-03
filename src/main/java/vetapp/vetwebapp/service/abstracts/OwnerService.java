package vetapp.vetwebapp.service.abstracts;

import java.util.List;

import vetapp.vetwebapp.entities.Owner;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface OwnerService {

	Result add(String username, String password, String email, String address, String firstName, String lastName);
	
	DataResult<List<Owner>> getAll();
	DataResult<Owner> getById(int id);
	
	
	
	
	
}
