package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.persistence.Photo;

import java.io.Serializable;
import java.util.Objects;


public class PhotoDto implements Serializable {

    private static final long serialVersionUID = 3217680915263537077L;

    private String photoURL;
    private String photoName;
    private Member member;

    public PhotoDto(String photoURL,String photoName, Member member) {
        this.photoURL = photoURL;
        this.photoName =photoName;
        this.member = member;
    }

    public PhotoDto(Photo photo){
        photo.setPhotoURL(photo.getPhotoURL());
        photo.setPhotoName(photo.getPhotoName());
        photo.setMember(photo.getMember());
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @JsonIgnore
    public Photo getPhotos(){
        return new Photo(getPhotoURL(),getPhotoName(),getMember());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotoDto photoDto = (PhotoDto) o;
        return Objects.equals(photoURL, photoDto.photoURL) && Objects.equals(photoName, photoDto.photoName) && Objects.equals(member, photoDto.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoURL, photoName, member);
    }

    @Override
    public String toString() {
        return "PhotoDto{" +
                "photoURL='" + photoURL + '\'' +
                ", photoName='" + photoName + '\'' +
                ", member=" + member +
                '}';
    }
}
