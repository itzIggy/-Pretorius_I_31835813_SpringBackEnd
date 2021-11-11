package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Photo;

@Repository
public interface RepoPhoto extends JpaRepository<Photo, Long> {
    /*@Query(value = "SELECT       " +
            "        at          " +
            "        FROM        " +
            "        Photo       " +
            "        at          " +
            "        JOIN Member " +
            "        me          " +
            "WHERE me.fname = :fname")
    Photo getAllPhotosByMembers(String memberFname);*/
}
