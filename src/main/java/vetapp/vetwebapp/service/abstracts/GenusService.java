package vetapp.vetwebapp.service.abstracts;

import java.util.List;
import java.util.Optional;

import vetapp.vetwebapp.entities.Genus;

public interface GenusService {
	List<Genus> getAll();
	Optional<Genus> getById(int id);
	void add(Genus genus);
	void deleteById(int id);
	void deleteAll();
}
