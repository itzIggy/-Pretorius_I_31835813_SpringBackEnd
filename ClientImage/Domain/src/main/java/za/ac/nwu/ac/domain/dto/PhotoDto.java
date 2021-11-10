package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.Photo;

import java.io.Serializable;
import java.util.Objects;


public class PhotoDto implements Serializable {

    private static final long serialVersionUID = 3217680915263537077L;

    private String photoName;

    public PhotoDto() {
    }

    public PhotoDto(Photo photo){
        photo.setPhotoName(photo.getPhotoName());
    }

    public PhotoDto(String photoName) {
        this.photoName = photoName;
    }

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
        PhotoDto photoDto = (PhotoDto) o;
        return Objects.equals(photoName, photoDto.photoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoName);
    }

    @Override
    public String toString() {
        return "PhotoDto{" +
                "photoName='" + photoName + '\'' +
                '}';
    }
}
