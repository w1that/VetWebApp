package vetapp.vetwebapp.service.abstracts;

import java.util.List;
import java.util.Optional;

import vetapp.vetwebapp.entities.Vet;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface VetService {
	
	DataResult<List<Vet>> getAll();
	DataResult<Optional<Vet>> getById(int id);
	Result add(Vet vet);
	Result deleteAll();
	Result deleteById(int id);
	
	
	DataResult<List<Vet>>  getByClinicNameLike(String like);
	DataResult<List<Vet>>  getByClinicNameContaining(String containing);
	DataResult<List<Vet>> getByIsActiveTrue();
	
	Result setActive(int vetId);
	
}
