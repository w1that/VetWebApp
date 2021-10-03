package vetapp.vetwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vetapp.vetwebapp.entities.images.PetImage;

public interface PetImageDao extends JpaRepository<PetImage, Integer>{
	List<PetImage> getByPetId(int petId);
}
