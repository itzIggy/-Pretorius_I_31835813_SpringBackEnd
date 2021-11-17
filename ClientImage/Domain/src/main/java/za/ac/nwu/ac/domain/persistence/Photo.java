package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "photo", schema = "imageclient")
public class Photo implements Serializable {

    private static final long serialVersionUID = 4683573925573853002L;

    private Long photoID;
    private String photoURL;
    private String photoName;
    private Member member;
    private MetaData metaData;

    public Photo() {
    }

    public Photo(Long photoID, String photoURL, String photoName) {
        this.photoID = photoID;
        this.photoURL = photoURL;
        this.photoName = photoName;
    }

    public Photo(String photoURL, String photoName) {
        this.photoURL = photoURL;
        this.photoName = photoName;
    }

    public Photo(String photoURL, String photoName, Member member){
        this.photoURL = photoURL;
        this.photoName = photoName;
        this.member = member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member getMember(){
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meta_id")
    public MetaData getMetaData(){
        return metaData;
    }

    public void setMetaData(MetaData metaData){
        this.metaData = metaData;
    }

    @Column(name = "photo_url")
    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
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
        return Objects.equals(photoID, photo.photoID) && Objects.equals(photoURL, photo.photoURL) && Objects.equals(photoName, photo.photoName) && Objects.equals(member, photo.member) && Objects.equals(metaData, photo.metaData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoID, photoURL, photoName, member, metaData);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoID=" + photoID +
                ", photoURL='" + photoURL + '\'' +
                ", photoName='" + photoName + '\'' +
                ", member=" + member +
                ", metaData=" + metaData +
                '}';
    }
}

