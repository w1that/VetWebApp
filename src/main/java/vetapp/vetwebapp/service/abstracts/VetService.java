package vetapp.vetwebapp.service.abstracts;

import java.util.List;
import java.util.Optional;

import vetapp.vetwebapp.entities.Vet;

public interface VetService {
	
	List<Vet> getAll();
	Optional<Vet> getById(int id);
	void add(Vet vet);
	void deleteAll();
	void deleteById(int id);
	
	
	List<Vet> getByClinicNameLike(String like);
	List<Vet> getByClinicNameContaining(String containing);
	List<Vet> getByIsActiveTrue();
	
	void setActive(int vetId);
	
}
