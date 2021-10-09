package vetapp.vetwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vetapp.vetwebapp.entities.Pet;

public interface PetDao extends JpaRepository<Pet, Integer>{

	List<Pet> findByGenusId(int id);
	
	List<Pet> findByOwnerId(int id);
}
