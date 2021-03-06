package vetapp.vetwebapp.service.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vetapp.vetwebapp.entities.images.VetImage;
import vetapp.vetwebapp.repository.VetImageDao;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.ErrorResult;
import vetapp.vetwebapp.results.Result;
import vetapp.vetwebapp.results.SuccessDataResult;
import vetapp.vetwebapp.results.SuccessResult;
import vetapp.vetwebapp.service.abstracts.VetImageService;
import vetapp.vetwebapp.utilities.imageUpload.ImageUploadService;

@Service
public class VetImageManager implements VetImageService {

	@Autowired
	VetImageDao vetImageDao;
	@Autowired
	ImageUploadService imageUploadService;
	
	@Override
	public Result upload(int vetId, VetImage vetImage, MultipartFile file) {
		try {
			if(this.vetImageDao.getByVetId(vetId).size()<5) {
				@SuppressWarnings("unchecked")
				Map<String,String> uploadedImage=(Map<String,String>)this.imageUploadService.upload(file).getData();
				vetImage.setImagePath(uploadedImage.get("url"));
				this.vetImageDao.save(vetImage);
				
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
	public DataResult<List<VetImage>> getAll() {
		try {
			return new SuccessDataResult<List<VetImage>>();
		} catch (Exception e) {
			return new ErrorDataResult<List<VetImage>>(e.toString());
		}
	}

	@Override
	public Result deleteById(int id) {
		try {
			this.vetImageDao.deleteById(id);
			return new SuccessResult("silindi. id: "+ id);
		} catch (Exception e) {
			return new ErrorResult(e.toString());
		}
	}

	@Override
	public DataResult<List<VetImage>> getByVetId(int id) {
		try {
			return new SuccessDataResult<List<VetImage>>(this.vetImageDao.getByVetId(id));
		} catch (Exception e) {
			return new ErrorDataResult<List<VetImage>>(e.toString());
		}
	}


	

	
}
