package za.ac.nwu.ac.translator.impl;

import com.amazonaws.services.elasticache.model.Authentication;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.domain.dto.PhotoDto;
import za.ac.nwu.ac.domain.persistence.Photo;
import za.ac.nwu.ac.repo.persistence.RepoPhoto;
import za.ac.nwu.ac.translator.PhotoTranslator;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@Component
@Transactional
@Slf4j
public class PhotoTranslatorImpl implements PhotoTranslator {

    private final RepoPhoto repoPhoto;

    @Value("imagestorage323")
    private String bucket;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    public PhotoTranslatorImpl(RepoPhoto repoPhoto) {
        this.repoPhoto = repoPhoto;
    }

    @Override
    public String uploadFile(MultipartFile file){
        File fileObject = convertMultipartFile(file);
        String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        amazonS3.putObject(new PutObjectRequest(bucket,filename,fileObject));
        fileObject.delete();
        return "File Uploaded : " + filename;
    }

    @Override
    public String getPhoto(String fileName) {
        S3Object s3Object = amazonS3.getObject(bucket, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            String encoded = Base64.getEncoder().encodeToString(content);
            return encoded;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public byte[] downloadPhoto(String fileName) {
        S3Object s3Object = amazonS3.getObject(bucket, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String deletePhoto(String fileName) {
        amazonS3.deleteObject(bucket,fileName);

        return fileName+" removed.";

    }

    @Override
    public String savePhoto(MultipartFile file) {

        File fileObj = convertMultipartFile(file);
        String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        amazonS3.putObject(new PutObjectRequest(bucket,filename,fileObj));
        fileObj.delete();
        return "File Uploaded : " + filename;
    }

    private File convertMultipartFile (MultipartFile file)
    {
        File convertedfile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedfile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Could not convert file", e);
        }
        return convertedfile;
    }

    public String deleteFile(String fileName){
        amazonS3.deleteObject(bucket,fileName);
        return  fileName + " removed...";
    }
}
