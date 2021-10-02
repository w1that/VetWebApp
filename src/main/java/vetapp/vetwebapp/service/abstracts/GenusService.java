package vetapp.vetwebapp.service.abstracts;

import java.util.List;
import java.util.Optional;

import vetapp.vetwebapp.entities.Genus;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.Result;

public interface GenusService {
	DataResult<List<Genus>> getAll();
	DataResult<Genus>  getById(int id);
	Result add(String name);
	Result deleteById(int id);
	Result deleteAll();
}
