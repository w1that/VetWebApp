package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.OwnerImage;
import vetapp.vetwebapp.entities.images.PetImage;
import vetapp.vetwebapp.repository.OwnerDao;
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
	private OwnerImageDao ownerImageDao;
	@Autowired
	private ImageUploadService imageUploadService;
	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public Result upload(int ownerId, OwnerImage ownerImage, MultipartFile file) {
		try {
			if(this.ownerDao.getById(ownerId).getImage() != null){
				return new ErrorResult("zaten bir fotoğrafı var. id: "+ ownerId);
			}
			else {
				@SuppressWarnings("unchecked")
				Map<String,String> uploadedImage=(Map<String,String>)this.imageUploadService.upload(file).getData();
				ownerImage.setImagePath(uploadedImage.get("url"));
				
				this.ownerImageDao.save(ownerImage);
				
				return new SuccessResult("image eklendi");
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

	@Override
	public Result deleteByOwnerId(int id) {
		try {
			if(this.ownerDao.getById(id).getImage()!=null) {
				this.ownerImageDao.deleteByOwnerId(id);
				return new SuccessResult("silindi. ownerid: "+ id);
			}
			return new ErrorResult();
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

}
