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
    private Long metaSize;
    private String metaType;

    private Set<Photo> photo;

    public MetaData() {
    }

    public MetaData(Long metaID, Long metaSize, String metaType) {
        this.metaID = metaID;
        this.metaSize = metaSize;
        this.metaType = metaType;
    }

    public MetaData(Long metaSize, String metaType) {
        this.metaSize = metaSize;
        this.metaType = metaType;
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

    @Column(name = "meta_size")
    public Long getMetaSize() {
        return metaSize;
    }

    public void setMetaSize(Long metaSize) {
        this.metaSize = metaSize;
    }

    @Column(name = "meta_type")
    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
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
        return Objects.equals(metaID, metaData.metaID) && Objects.equals(metaSize, metaData.metaSize) && Objects.equals(metaType, metaData.metaType) && Objects.equals(photo, metaData.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaID, metaSize, metaType, photo);
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "metaID=" + metaID +
                ", metaSize='" + metaSize + '\'' +
                ", metaType='" + metaType + '\'' +
                ", photo=" + photo +
                '}';
    }
}


