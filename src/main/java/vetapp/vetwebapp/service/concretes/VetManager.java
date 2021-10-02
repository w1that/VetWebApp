package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vetapp.vetwebapp.entities.Vet;
import vetapp.vetwebapp.repository.VetDao;
import vetapp.vetwebapp.service.abstracts.VetService;

@Service
public class VetManager implements VetService{

	@Autowired
	private VetDao vetDao;
	
	@Override
	public List<Vet> getAll() {
		return this.vetDao.findAll();
	}

	@Override
	public Optional<Vet> getById(int id) {
		return this.vetDao.findById(id);
	}

	@Override
	public void add(Vet vet) {
		this.vetDao.save(vet);
		
	}

	@Override
	public void deleteAll() {
		this.vetDao.deleteAll();
	}

	@Override
	public void deleteById(int id) {
		this.vetDao.deleteById(id);
	}

	@Override
	public List<Vet> getByClinicNameLike(String like) {
		return this.vetDao.findByClinicNameLike(like);
	}

	@Override
	public List<Vet> getByClinicNameContaining(String containing) {
		return this.vetDao.findByClinicNameContaining(containing);
	}

	@Override
	public List<Vet> getByIsActiveTrue() {
		return this.vetDao.findByIsActiveTrue();
	}

	@Override
	public void setActive(int vetId) {
		this.vetDao.setActive(vetId);
	}
}
