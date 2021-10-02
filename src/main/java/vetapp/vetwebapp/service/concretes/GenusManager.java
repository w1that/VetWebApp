package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vetapp.vetwebapp.entities.Genus;
import vetapp.vetwebapp.repository.GenusDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.GenusService;

@Service
public class GenusManager implements GenusService{

	@Autowired
	private GenusDao genusDao;
	
	@Override
	public DataResult<List<Genus>> getAll() {
		try {
			return new SuccessDataResult<List<Genus>>(genusDao.findAll());
		} catch (Exception e) {
			return new ErrorDataResult<List<Genus>>(e.toString());
		}
	}

	@Override
	public DataResult<Genus> getById(int id) {
		try {
			return new SuccessDataResult<Genus>(this.genusDao.getById(id));
		} catch (Exception e) {
			return new ErrorDataResult<Genus>(e.toString());
		}
	}

	@Override
	public Result add(String name) {
		try {
			Genus genus = new Genus();
			genus.setName(name);
			this.genusDao.save(genus);
			return new SuccessResult("eklendi "+ genus);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
		
	}

	@Override
	public Result deleteById(int id) {
		try {
			this.genusDao.deleteById(id);
			return new SuccessResult("silindi id:" + Integer.toString(id));
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public Result deleteAll() {
		try {
			this.genusDao.deleteAll();
			return new SuccessResult("hepsi silindi. genuses:"+ genusDao.findAll());
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}
	
	

}
