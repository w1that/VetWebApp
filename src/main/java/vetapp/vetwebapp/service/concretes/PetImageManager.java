package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.PetImage;
import vetapp.vetwebapp.repository.PetImageDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.PetImageService;
import vetapp.vetwebapp.utilities.imageUpload.ImageUploadService;
@Service
public class PetImageManager implements PetImageService{

	@Autowired
	PetImageDao petImageDao;
	@Autowired
	ImageUploadService imageUploadService;
	
	@Override
	public Result upload(int petId, PetImage petImage, MultipartFile file) {
		try {
			if(this.petImageDao.getByPetId(petId).size()<5) {
				@SuppressWarnings("unchecked")
				Map<String,String> uploadedImage=(Map<String,String>)this.imageUploadService.upload(file).getData();
				petImage.setImagePath(uploadedImage.get("url"));
				
				this.petImageDao.save(petImage);
				
				return new SuccessResult("image eklendi");
			}
			else {
				return new ErrorResult("en fazla 5 image eklenebilir");
			}
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<PetImage>> getAll() {
		try {
			return new SuccessDataResult<List<PetImage>>(this.petImageDao.findAll());
		} catch (Exception e) {
			return new ErrorDataResult<List<PetImage>>(e.toString());
		}
	}

	@Override
	public Result deleteById(int id) {
		try {
			this.petImageDao.deleteById(id);
			return new SuccessResult("silindi. id: "+ id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<PetImage>> getByPetId(int id) {
		try {
			return new SuccessDataResult<List<PetImage>>(this.petImageDao.getByPetId(id));
		} catch (Exception e) {
			return new ErrorDataResult<List<PetImage>>(e.toString());
		}
	}


}
