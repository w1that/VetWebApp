package vetapp.vetwebapp.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import vetapp.vetwebapp.results.DataResult;
import vetapp.vetwebapp.results.ErrorDataResult;
import vetapp.vetwebapp.results.SuccessDataResult;

@Service
public class ImageUploadManager implements ImageUploadService {

	@Override
	public DataResult<Map> upload(MultipartFile file) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dp39jsge0",
				"api_key", "172183256184911",
				"api_secret", "2iSM7c9p8xkmLZS89E-9-vMjKwI"));
		
		
			try {
			Map uploadResult= cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
				return new SuccessDataResult<Map>(uploadResult);
			} catch (Exception e) {
				return new ErrorDataResult<Map>(e.toString());
			}
	}

}
