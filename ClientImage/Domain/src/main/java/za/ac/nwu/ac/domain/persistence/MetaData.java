package za.ac.nwu.ac.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "metadata", schema = "imageclient")
public class MetaData implements Serializable {

    private static final long serialVersionUID = -2291190826579963737L;

    private Long metaID;
    private String metaGeoLocation;
    private String metaAuthor;
    private LocalDate metaDate;
    private String metaTag;

    private Set<Photo> photo;

    public MetaData() {
    }

    public MetaData(Long metaID, String metaGeoLocation, String metaAuthor, LocalDate metaDate, String metaTag) {
        this.metaID = metaID;
        this.metaGeoLocation = metaGeoLocation;
        this.metaAuthor = metaAuthor;
        this.metaDate = metaDate;
        this.metaTag = metaTag;
    }

    public MetaData(String metaGeoLocation, String metaAuthor, LocalDate metaDate, String metaTag) {
        this.metaGeoLocation = metaGeoLocation;
        this.metaAuthor = metaAuthor;
        this.metaDate = metaDate;
        this.metaTag = metaTag;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_id")
    public Long getMetaID() {
        return metaID;
    }

    public void setMetaID(Long metaID) {
        this.metaID = metaID;
    }

    @Column(name = "meta_geolocation")
    public String getMetaGeoLocation() {
        return metaGeoLocation;
    }

    public void setMetaGeoLocation(String metaGeoLocation) {
        this.metaGeoLocation = metaGeoLocation;
    }

    @Column(name = "meta_author")
    public String getMetaAuthor() {
        return metaAuthor;
    }

    public void setMetaAuthor(String metaAuthor) {
        this.metaAuthor = metaAuthor;
    }

    @Column(name = "meta_date")
    public LocalDate getMetaDate() {
        return metaDate;
    }

    public void setMetaDate(LocalDate metaDate) {
        this.metaDate = metaDate;
    }

    @Column(name = "meta_tag")
    public String getMetaTag() {
        return metaTag;
    }

    public void setMetaTag(String metaTag) {
        this.metaTag = metaTag;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Photo.class, fetch = FetchType.LAZY, mappedBy = "metaData")
    public Set<Photo> getPhoto(){
        return photo;
    }

    public void setPhoto(Set<Photo> photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaData metaData = (MetaData) o;
        return Objects.equals(metaID, metaData.metaID) && Objects.equals(metaGeoLocation, metaData.metaGeoLocation) && Objects.equals(metaAuthor, metaData.metaAuthor) && Objects.equals(metaDate, metaData.metaDate) && Objects.equals(metaTag, metaData.metaTag) && Objects.equals(photo, metaData.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaID, metaGeoLocation, metaAuthor, metaDate, metaTag, photo);
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "metaID=" + metaID +
                ", metaGeoLocation='" + metaGeoLocation + '\'' +
                ", metaAuthor='" + metaAuthor + '\'' +
                ", metaDate=" + metaDate +
                ", metaTag='" + metaTag + '\'' +
                ", photo=" + photo +
                '}';
    }
}


