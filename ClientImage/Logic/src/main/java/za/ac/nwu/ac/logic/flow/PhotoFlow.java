package za.ac.nwu.ac.logic.flow;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoFlow {

    String GetPhoto(String fileName);

    String DeletePhoto(String fileName);

    String SavePhoto(MultipartFile file);

    byte[] DownloadPhoto(String fileName);

    String uploadFile(MultipartFile file);

    String deleteFile(String fileName);
}
