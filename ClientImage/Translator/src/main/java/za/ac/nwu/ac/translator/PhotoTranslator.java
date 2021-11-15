package za.ac.nwu.ac.translator;

import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.domain.dto.PhotoDto;

public interface PhotoTranslator {

    String getPhoto(String fileName);

    String deletePhoto(String fileName);

    String savePhoto(MultipartFile file);

    byte[] downloadPhoto(String fileName);

    String uploadFile(MultipartFile file);

    String deleteFile(String fileName);
}
