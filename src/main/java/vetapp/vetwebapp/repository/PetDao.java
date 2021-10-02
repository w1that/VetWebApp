package vetapp.vetwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vetapp.vetwebapp.entities.Pet;

public interface PetDao extends JpaRepository<Pet, Integer>{

}
