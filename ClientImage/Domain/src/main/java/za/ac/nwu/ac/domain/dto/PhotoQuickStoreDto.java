package za.ac.nwu.ac.domain.dto;

import java.io.Serializable;
import java.util.Objects;

public class PhotoQuickStoreDto implements Serializable {

    private static final long serialVersionUID = 7458369508301744695L;

    private String photoBase64;
    private String photoName;

    public PhotoQuickStoreDto() {
    }

    public PhotoQuickStoreDto(String photoBase64, String photoName) {
        this.photoBase64 = photoBase64;
        this.photoName = photoName;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
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
        PhotoQuickStoreDto that = (PhotoQuickStoreDto) o;
        return Objects.equals(photoBase64, that.photoBase64) && Objects.equals(photoName, that.photoName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoBase64, photoName);
    }

    @Override
    public String toString() {
        return "PhotoQuickStoreDto{" +
                "photoBase64='" + photoBase64 + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
