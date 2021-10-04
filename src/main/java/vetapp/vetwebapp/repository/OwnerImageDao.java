package vetapp.vetwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vetapp.vetwebapp.entities.images.OwnerImage;


public interface OwnerImageDao extends JpaRepository<OwnerImage, Integer> {
	List<OwnerImage> getByOwnerId(int ownerId);
	
	@Query(value="DELETE FROM public.owner_images\r\n"
			+ "	WHERE owner_id=:ownerId", nativeQuery = true)
	void deleteByOwnerId(int ownerId);
}
