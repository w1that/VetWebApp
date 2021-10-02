package vetapp.vetwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vetapp.vetwebapp.entities.images.VetImage;

public interface VetImageDao extends JpaRepository<VetImage, Integer> {
	List<VetImage> getByVetId(int vetId);
}
