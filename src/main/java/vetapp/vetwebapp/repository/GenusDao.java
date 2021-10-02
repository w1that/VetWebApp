package vetapp.vetwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vetapp.vetwebapp.entities.Genus;

public interface GenusDao extends JpaRepository<Genus, Integer> {

}
