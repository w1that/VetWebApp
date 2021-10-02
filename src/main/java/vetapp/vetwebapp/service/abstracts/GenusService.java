package vetapp.vetwebapp.service.abstracts;

import java.util.List;
import java.util.Optional;

import vetapp.vetwebapp.entities.Genus;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface GenusService {
	DataResult<List<Genus>> getAll();
	DataResult<Optional<Genus>>  getById(int id);
	Result add(Genus genus);
	Result deleteById(int id);
	Result deleteAll();
}
