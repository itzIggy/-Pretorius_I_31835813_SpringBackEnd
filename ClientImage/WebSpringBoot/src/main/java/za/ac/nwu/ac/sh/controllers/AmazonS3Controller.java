package za.ac.nwu.ac.sh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.sh.service.AmazonS3Service;

@RestController
@RequestMapping("/storage")
public class AmazonS3Controller {

    @Autowired
    private AmazonS3Service service;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file")MultipartFile multipartFile){
        return new ResponseEntity<>(service.uploadFile(multipartFile), HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition","attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/deleteFile/{fileName}")
    public ResponseEntity<String> deleteFile(String fileName){
        return new ResponseEntity<>(service.deleteFile(fileName),HttpStatus.OK);
    }
}
