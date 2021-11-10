package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "photo", schema = "imageclient")
public class Photo implements Serializable {

    private static final long serialVersionUID = 4683573925573853002L;

    private Long photoID;
    private String photoName;

    public Photo() {
    }

    public Photo(Long photoID, String photoName) {
        this.photoID = photoID;
        this.photoName = photoName;
    }

    public Photo(String photoName) {
        this.photoName = photoName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    public Long getPhotoID() {
        return photoID;
    }

    public void setPhotoID(Long photoID) {
        this.photoID = photoID;
    }

    @Column(name = "photo_name")
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(photoID, photo.photoID) && Objects.equals(photoName, photo.photoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoID, photoName);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoID=" + photoID +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}

