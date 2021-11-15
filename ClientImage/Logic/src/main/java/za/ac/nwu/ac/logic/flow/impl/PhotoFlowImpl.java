package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import za.ac.nwu.ac.logic.flow.PhotoFlow;
import za.ac.nwu.ac.translator.MemberTranslator;
import za.ac.nwu.ac.translator.PhotoTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class PhotoFlowImpl implements PhotoFlow {

    private final PhotoTranslator photoTranslator;

    @Autowired
    public PhotoFlowImpl(PhotoTranslator photoTranslator){
        this.photoTranslator = photoTranslator;
    }

    @Override
    public String GetPhoto(String fileName){
        return photoTranslator.getPhoto(fileName);
    }

    @Override
    public String uploadFile(MultipartFile file){return photoTranslator.uploadFile(file);}

    @Override
    public String DeletePhoto(String fileName){
        return photoTranslator.deletePhoto(fileName);
    }

    @Override
    public String SavePhoto(MultipartFile file){
        return photoTranslator.savePhoto(file);
    }

    @Override
    public byte[] DownloadPhoto(String fileName){
        return photoTranslator.downloadPhoto(fileName);
    }

    @Override
    public String deleteFile(String fileName){return photoTranslator.deleteFile(fileName);}
}
