package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.istack.NotNull;

import vetapp.vetwebapp.entities.Vet;
import vetapp.vetwebapp.entities.images.VetImage;
import vetapp.vetwebapp.repository.VetDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.VetService;

@Service
public class VetManager implements VetService{

	@Autowired
	private VetDao vetDao;
	
	@Override
	public DataResult<List<Vet>> getAll() {
		try {
			return new SuccessDataResult<List<Vet>>(this.vetDao.findAll());
		} catch (Exception e) {
			return new ErrorDataResult<List<Vet>>(e.toString());
		}
	}

	@Override
	public DataResult<Vet> getById(int id) {
		try {
			return new SuccessDataResult<Vet>(this.vetDao.findById(id).get());
		} catch (Exception e) {
			return new ErrorDataResult<Vet>(e.toString());
		}
	}

	
	@Override
	public Result deleteAll() {
		try {
			this.vetDao.deleteAll();
			return new SuccessResult("hepsi silindi");
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public Result deleteById(int id) {
		try {
			this.vetDao.deleteById(id);
			return new SuccessResult("silindi. id:" + id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<Vet>> getByClinicNameLike(String like) {
		try {
			return new SuccessDataResult<List<Vet>>(this.vetDao.findByClinicNameLike(like), "öğe bulundu: "+ this.vetDao.findByClinicNameLike(like).size()+ " tane" );
		} catch (Exception e) {
			return new ErrorDataResult<List<Vet>>(e.toString());
		}
	}

	@Override
	public DataResult<List<Vet>> getByClinicNameContaining(String containing) {
		try {
			return new SuccessDataResult<List<Vet>>(this.vetDao.findByClinicNameContaining(containing), "klinik ismi '"+ containing+ "' içerenler getirildi");
		} catch (Exception e) {
			return new ErrorDataResult<List<Vet>>(e.toString());
		}
	}

	@Override
	public DataResult<List<Vet>> getByIsActiveTrue() {
		try {
			return new SuccessDataResult<List<Vet>>(this.vetDao.findByIsActiveTrue(), "aktif olanlar getirildi.");
		} catch (Exception e) {
			return new ErrorDataResult<List<Vet>>(e.toString());
		}
	}

	@Override
	public Result setActive(int vetId) {
		try {
			this.vetDao.setActive(vetId);
			return new SuccessResult("aktif edildi.");
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public Result add(String username, String password, String clinicName, String email, String latitude, String longitude) {
		// username, password, clinicName, email, address
		try {
			if(username.length()>6 && password.length()>=6) {
				Vet vet = new Vet();
				vet.setUsername(username);
				vet.setPassword(password);
				vet.setClinicName(clinicName);
				vet.setEmail(email);
				vet.setLatitude(latitude);
				vet.setLongitude(longitude);
				this.vetDao.save(vet);
				return new SuccessResult("eklendi. yeni vet:" + vet);
			}
			else {
				return new ErrorResult("Kullanıcı adı ve şifre en az 6 haneli olmalıdır.");
			}
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}
}
