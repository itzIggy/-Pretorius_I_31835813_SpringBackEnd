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
    private String photoType;
    private Member member;
    private MetaData metaData;

    public Photo() {
    }

    public Photo(Long photoID, String photoName, String photoType) {
        this.photoID = photoID;
        this.photoName = photoName;
        this.photoType = photoType;
    }

    public Photo(String photoName, String photoType, Member member, MetaData metaData) {
        this.photoName = photoName;
        this.photoType = photoType;
        this.member = member;
        this.metaData = metaData;
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
    @JoinColumn(name = "memberid")
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

    @Column(name = "photo_name")
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Column(name = "photo_type")
    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(photoID, photo.photoID) && Objects.equals(photoName, photo.photoName) && Objects.equals(photoType, photo.photoType) && Objects.equals(member, photo.member) && Objects.equals(metaData, photo.metaData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoID, photoName, photoType, member, metaData);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoID=" + photoID +
                ", photoName='" + photoName + '\'' +
                ", photoType='" + photoType + '\'' +
                ", member=" + member +
                '}';
    }
}

