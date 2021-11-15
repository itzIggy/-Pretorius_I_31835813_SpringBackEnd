/*
package za.ac.nwu.ac.sh.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.logging.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class AmazonS3Service {

    @Value("imagestorage323")
    private String bucket;

    @Autowired
    public AmazonS3 s3;

    public String uploadFile(MultipartFile file){
        File fileObject = convertMultipartFile(file);
        String filename = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        s3.putObject(new PutObjectRequest(bucket,filename,fileObject));
        fileObject.delete();
        return "File Uploaded : " + filename;
    }

    public byte[] downloadFile(String fileName){
        S3Object s3Object = s3.getObject(bucket,fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File convertMultipartFile(MultipartFile file){
        File convertedFile = new File(file.getOriginalFilename());
        try(FileOutputStream fileOutput = new FileOutputStream(convertedFile)){
            fileOutput.write(file.getBytes());
        } catch(IOException e){
            log.error("Error converting file!",e);
        }
        return convertedFile;
    }

    public String deleteFile(String fileName){
        s3.deleteObject(bucket,fileName);
        return  fileName + " removed...";
    }


}
*/
