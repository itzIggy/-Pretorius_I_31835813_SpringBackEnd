/*package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.PhotoDto;
import za.ac.nwu.ac.domain.persistence.Photo;
import za.ac.nwu.ac.repo.persistence.RepoPhoto;
import za.ac.nwu.ac.translator.photoTranslator;

import javax.transaction.Transactional;

@Component
@Transactional
public class photoTranslatorImpl implements photoTranslator {

    private final RepoPhoto repoPhoto;

    @Autowired
    public photoTranslatorImpl(RepoPhoto repoPhoto) {
        this.repoPhoto = repoPhoto;
    }

    @Override
    public PhotoDto getAllPhotosByMembers(String memberFname) {
        try{
            Photo photo = repoPhoto.getAllPhotosByMembers(memberFname);
            return new PhotoDto(photo);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB");
        }
    }
}*/
