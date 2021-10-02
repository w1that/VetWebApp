package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vetapp.vetwebapp.entities.Genus;
import vetapp.vetwebapp.repository.GenusDao;
import vetapp.vetwebapp.service.abstracts.GenusService;

@Service
public class GenusManager implements GenusService{

	@Autowired
	private GenusDao genusDao;
	
	@Override
	public List<Genus> getAll() {
		return genusDao.findAll();
	}

	@Override
	public Optional<Genus> getById(int id) {
		return genusDao.findById(id);
	}

	@Override
	public void add(Genus genus) {
		this.genusDao.save(genus);
	}

	@Override
	public void deleteById(int id) {
		this.genusDao.deleteById(id);
	}

	@Override
	public void deleteAll() {
		this.genusDao.deleteAll();
	}
	
	

}
