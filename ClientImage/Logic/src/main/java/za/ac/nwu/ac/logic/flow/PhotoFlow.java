package za.ac.nwu.ac.logic.flow;

import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.domain.dto.PhotoQuickStoreDto;
import za.ac.nwu.ac.domain.persistence.Photo;

import java.util.List;

public interface PhotoFlow {

    List<PhotoQuickStoreDto> getPhotos();

    String DeletePhoto(String fileName);

    byte[] DownloadPhoto(String fileName);

    String uploadFile(MultipartFile file);

    String deleteFile(String fileName);

    List<PhotoQuickStoreDto> getPhotosByPhotoName(String photoName);
}
