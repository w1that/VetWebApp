package vetapp.vetwebapp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import vetapp.vetwebapp.entities.Owner;

public interface OwnerDao extends JpaRepository<Owner, Integer> {

	
	Owner findByEmailContaining(String email);
	Owner findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value="update owner set is_active=true where id=:ownerId", nativeQuery = true)
	void setActive(int ownerId);
	
	@Transactional
	@Modifying
	@Query(value="update owner set premium=true where id=:ownerId", nativeQuery = true)
	void setPremium(int ownerId);
	
	@Transactional
	@Modifying
	@Query(value="update owner set premium=false where id=:ownerId", nativeQuery = true)
	void setNotPremium(int ownerId);
	
}
