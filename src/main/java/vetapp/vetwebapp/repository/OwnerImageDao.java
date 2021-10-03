package vetapp.vetwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import vetapp.vetwebapp.entities.images.OwnerImage;


public interface OwnerImageDao extends JpaRepository<OwnerImage, Integer> {
	List<OwnerImage> getByOwnerId(int ownerId);
}
