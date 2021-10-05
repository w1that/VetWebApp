package vetapp.vetwebapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import vetapp.vetwebapp.entities.Vet;

public interface VetDao extends JpaRepository<Vet, Integer>{

	public List<Vet> findByClinicNameLike(String like);
	public List<Vet> findByClinicNameContaining(String containing);
	public List<Vet> findByIsActiveTrue();
	public Vet findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value="update vets set is_active=true where id=:vetId", nativeQuery = true)
	void setActive(int vetId);
	
	
}
