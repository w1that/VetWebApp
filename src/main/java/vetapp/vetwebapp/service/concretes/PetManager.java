package vetapp.vetwebapp.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vetapp.vetwebapp.entities.Pet;
import vetapp.vetwebapp.repository.GenusDao;
import vetapp.vetwebapp.repository.OwnerDao;
import vetapp.vetwebapp.repository.PetDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.PetService;

@Service
public class PetManager implements PetService {
	
	@Autowired
	private PetDao petDao;
	@Autowired
	private GenusDao genusDao;
	@Autowired
	private OwnerDao ownerDao;

	@Override
	public Result add(String disease, String description, int age, int genusId, int ownerId) {
		try {
			if(this.ownerDao.getById(ownerId).getPets().size()==1 && !this.ownerDao.getById(ownerId).isPremium()) {
				return new ErrorResult("normal üyelikte en fazla 1 pet ekleyebilirsiniz.");
			}
			Pet pet = new Pet();
			pet.setAge(age);
			pet.setDisease(disease);
			pet.setGenus(genusDao.getById(genusId));
			pet.setOwner(ownerDao.getById(ownerId));
			pet.setDescription(description);
			
			this.petDao.save(pet);
			return new SuccessResult("eklendi. pet: "+ pet);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public Result deleteById(int id) {
		try {
			this.petDao.deleteById(id);
			return new SuccessResult("silindi. id: "+ id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
		
	}

	@Override
	public Result deleteAll() {
		try {
			this.petDao.deleteAll();
			return new SuccessResult("hepsi silindi");
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<Pet>> getAll() {
		try {
			return new SuccessDataResult<List<Pet>>(this.petDao.findAll());
		} catch (Exception e) {
			return new ErrorDataResult<List<Pet>>(e.toString());
		}
	}

	@Override
	public DataResult<Pet> getById(int id) {
		try {
			return new SuccessDataResult<Pet>(this.petDao.findById(id).get());
		} catch (Exception e) {
			return new ErrorDataResult<Pet>(e.toString());
		}
	}

	@Override
	public DataResult<List<Pet>> getByGenusId(int id) {
		try {
			return new SuccessDataResult<List<Pet>>(this.petDao.findByGenusId(id));
		} catch (Exception e) {
			return new ErrorDataResult<List<Pet>>(e.toString());
		}
	}

	@Override
	public DataResult<List<Pet>> getByOwnerId(int id) {
		try {
			return new SuccessDataResult<List<Pet>>(this.petDao.findByOwnerId(id));
		} catch (Exception e) {
			return new ErrorDataResult<List<Pet>>(e.toString());
		}
	}

}
