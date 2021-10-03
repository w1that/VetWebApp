package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.OwnerImage;
import vetapp.vetwebapp.entities.images.PetImage;
import vetapp.vetwebapp.repository.OwnerImageDao;
import vetapp.vetwebapp.repository.PetImageDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.OwnerImageService;
import vetapp.vetwebapp.utilities.imageUpload.ImageUploadService;

@Service
public class OwnerImageManager implements OwnerImageService {

	@Autowired
	OwnerImageDao ownerImageDao;
	@Autowired
	ImageUploadService imageUploadService;
	
	@Override
	public Result upload(int ownerId, OwnerImage ownerImage, MultipartFile file) {
		try {
			if(this.ownerImageDao.getByOwnerId(ownerId).size()<5) {
				@SuppressWarnings("unchecked")
				Map<String,String> uploadedImage=(Map<String,String>)this.imageUploadService.upload(file).getData();
				ownerImage.setImagePath(uploadedImage.get("url"));
				
				this.ownerImageDao.save(ownerImage);
				
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
	public DataResult<List<OwnerImage>> getAll() {
		try {
			return new SuccessDataResult<List<OwnerImage>>(this.ownerImageDao.findAll());
		} catch (Exception e) {
			return new ErrorDataResult<List<OwnerImage>>(e.toString());
		}
	}

	@Override
	public Result deleteById(int id) {
		try {
			this.ownerImageDao.deleteById(id);
			return new SuccessResult("silindi. id: "+ id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<OwnerImage>> getByOwnerId(int id) {
		try {
			return new SuccessDataResult<List<OwnerImage>>(this.ownerImageDao.getByOwnerId(id));
		} catch (Exception e) {
			return new ErrorDataResult<List<OwnerImage>>(e.toString());
		}
	}

}
