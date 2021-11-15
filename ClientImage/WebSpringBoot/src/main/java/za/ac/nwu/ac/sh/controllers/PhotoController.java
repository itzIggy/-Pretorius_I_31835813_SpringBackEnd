package za.ac.nwu.ac.sh.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.PhotoFlow;

import java.util.List;

@RestController
@RequestMapping("photo")
public class PhotoController {

    private final PhotoFlow photoFlow;

    @Autowired
    public PhotoController (PhotoFlow photoFlow){this.photoFlow=photoFlow;}

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile multipartFile){
        return new ResponseEntity<>(photoFlow.uploadFile(multipartFile), HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
        byte[] data = photoFlow.DownloadPhoto(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition","attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/deleteFile/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
        return new ResponseEntity<>(photoFlow.deleteFile(fileName),HttpStatus.OK);
    }

    @GetMapping("/getPhoto/{fileName}")
    public ResponseEntity<String> getPhoto(@PathVariable String fileName){
        return new ResponseEntity<>(photoFlow.GetPhoto(fileName),HttpStatus.OK);
    }

    @GetMapping("/savePhoto/{file}")
    public ResponseEntity<String> savePhoto(@PathVariable MultipartFile file){
        return new ResponseEntity<>(photoFlow.SavePhoto(file),HttpStatus.OK);
    }

}
