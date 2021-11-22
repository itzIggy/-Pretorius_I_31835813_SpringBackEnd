package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.PhotoQuickStoreDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.persistence.MetaData;
import za.ac.nwu.ac.domain.persistence.Photo;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RepoPhoto extends JpaRepository<Photo, Long> {
    @Query(value = "SELECT" +
            "       photos"+
            "       FROM"+
            "       Photo photos"+
            "       WHERE photos.member.memberID = :memberID")
    List<Photo> getPhotosByID(Long memberID);

    @Query(value = "SELECT" +
            "       photos"+
            "       FROM"+
            "       Photo photos"+
            "       WHERE photos.member.memberID = :memberID"+
            "       AND"+
            "       photos.photoName LIKE :photoName"+
            "       OR"+
            "       photos.photoURL LIKE :photoName")
    List<Photo> getPhotoByPhotoName(String photoName , Long memberID);

    @Transactional
    @Modifying
    @Query(value = "DELETE" +
            "       FROM"+
            "       Photo photos "+
            "       WHERE photos.photoURL = :photoURL")
    void deletePhotoByPhotoName(String photoURL);
/*
    @Transactional
    @Modifying
    @Query(value = "DELETE Photo.metaData" +
            "       FROM"+
            "       Photo photos"+
            "       WHERE photos.photoName = :photoName", nativeQuery = true)
    void deleteMetaByPhoto(String photoName);*/

}
