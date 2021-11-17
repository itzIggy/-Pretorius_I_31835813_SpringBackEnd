package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.persistence.Photo;

import java.util.List;

@Repository
public interface RepoPhoto extends JpaRepository<Photo, Long> {
    @Query(value = "SELECT" +
            "       photos"+
            "       FROM"+
            "       Photo photos"+
            "       WHERE photos.member.memberID = :memberID")
    List<Photo> getPhotosByID(Long memberID);


}
