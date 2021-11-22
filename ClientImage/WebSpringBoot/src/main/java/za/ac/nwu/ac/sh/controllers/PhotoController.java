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
import za.ac.nwu.ac.domain.dto.PhotoDto;
import za.ac.nwu.ac.domain.dto.PhotoQuickStoreDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.PhotoFlow;

import java.util.List;

@RestController
@RequestMapping("photo")
@CrossOrigin("*")
public class PhotoController {

    private final PhotoFlow photoFlow;

    @Autowired
    public PhotoController (PhotoFlow photoFlow){this.photoFlow=photoFlow;}

    @PostMapping("/uploadFile")
    public ResponseEntity<GeneralResponse<String>> uploadFile(@RequestParam(value = "file") MultipartFile multipartFile){
        GeneralResponse<String> response = new GeneralResponse<>(true,photoFlow.uploadFile(multipartFile));
        return new ResponseEntity<>(response, HttpStatus.OK);
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
    public ResponseEntity<GeneralResponse<String>> deleteFile(@PathVariable String fileName){
        GeneralResponse<String> response = new GeneralResponse<>(true,photoFlow.deleteFile(fileName));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getPhotos")
    public ResponseEntity<GeneralResponse<List<PhotoQuickStoreDto>>> getPhoto(){
        List<PhotoQuickStoreDto> photoDtos = photoFlow.getPhotos();
        GeneralResponse<List<PhotoQuickStoreDto>> response = new GeneralResponse<>(true,photoDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/searchPhoto/{fileName}")
    public ResponseEntity<GeneralResponse<List<PhotoQuickStoreDto>>> searchPhoto(@PathVariable final String fileName){
        List<PhotoQuickStoreDto> photoDtos = photoFlow.getPhotosByPhotoName(fileName);
        GeneralResponse<List<PhotoQuickStoreDto>> response = new GeneralResponse<>(true,photoDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
