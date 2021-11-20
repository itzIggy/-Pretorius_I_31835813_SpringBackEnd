package za.ac.nwu.ac.translator;

import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.domain.dto.PhotoDto;
import za.ac.nwu.ac.domain.dto.PhotoQuickStoreDto;

import java.util.List;

public interface PhotoTranslator {

    List<PhotoQuickStoreDto> getPhotos();

    String deletePhoto(String fileName);

    byte[] downloadPhoto(String fileName);

    String uploadFile(MultipartFile file);

    String deleteFile(String fileName);
}
