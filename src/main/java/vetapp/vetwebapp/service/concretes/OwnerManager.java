package vetapp.vetwebapp.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vetapp.vetwebapp.entities.Owner;
import vetapp.vetwebapp.repository.OwnerDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.OwnerService;

@Service
public class OwnerManager implements OwnerService {
	
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public Result add(String username, String password, String email, String latitude, String longitude, String firstName,
			String lastName) {
		if(this.ownerDao.findByEmailContaining(email) !=null) {
			
			return new ErrorResult("email adresi daha önce alınmış");
		}
		if(this.ownerDao.findByUsername(username)!=null) {
			return new ErrorResult("kullanıcı adı daha önce alınmış");
		}
		Owner owner = new Owner();
		owner.setUsername(username);
		owner.setPassword(password);
		owner.setEmail(email);
		owner.setLatitude(latitude);
		owner.setLongitude(longitude);
		owner.setFirstName(firstName);
		owner.setLastName(lastName);
		try {
			this.ownerDao.save(owner);
			return new SuccessResult("eklendi: "+ owner);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<Owner>> getAll() {
		try {
			return new SuccessDataResult<List<Owner>>(this.ownerDao.findAll());
		} catch (Exception e) {
			return new ErrorDataResult<List<Owner>>(e.toString());
		}
	}

	@Override
	public DataResult<Owner> getById(int id) {
		try {
			return new SuccessDataResult<Owner>(this.ownerDao.findById(id).get());
		} catch (Exception e) {
			return new ErrorDataResult<Owner>(e.toString());
		}
	}

	@Override
	public DataResult<Owner> getByEmail(String email) {
		try {
			return new SuccessDataResult<Owner>(this.ownerDao.findByEmailContaining(email));
		} catch (Exception e) {
			return new ErrorDataResult<Owner>("bulunamadı");
		}
	}

	@Override
	public Result setPremium(int id) {
		try {
			this.ownerDao.setPremium(id);
			return new SuccessResult("premium hesaba geçti. id: "+ id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public Result setNotPremium(int id) {
		try {
			this.ownerDao.setNotPremium(id);
			return new SuccessResult("normal hesaba geçti. id: "+ id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<Owner> getByUsername(String username) {
		try {
			return new SuccessDataResult<Owner>(this.ownerDao.findByUsername(username));
		} catch (Exception e) {
			return new ErrorDataResult(e.toString());
		}
	}

	

}
