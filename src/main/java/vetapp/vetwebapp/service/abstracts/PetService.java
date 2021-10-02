package vetapp.vetwebapp.service.abstracts;

import java.util.List;

import vetapp.vetwebapp.entities.Pet;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface PetService {
	
	Result add(String disease, int age, int genusId, int ownerId);
	Result deleteById(int id);
	Result deleteAll();
	
	DataResult<List<Pet>> getAll();
	DataResult<Pet> getById(int id);
	

}
