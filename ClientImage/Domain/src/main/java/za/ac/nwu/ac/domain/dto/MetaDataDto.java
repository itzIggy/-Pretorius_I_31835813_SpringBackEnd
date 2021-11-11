package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.MetaData;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MetaDataDto implements Serializable {

    private static final long serialVersionUID = -1060158268568159328L;

    private String metaGeoLocation;
    private String metaAuthor;
    private LocalDate metaDate;
    private String metaTag;

    public MetaDataDto() {
    }

    public MetaDataDto(String metaGeoLocation, String metaAuthor, LocalDate metaDate, String metaTag) {
        this.metaGeoLocation = metaGeoLocation;
        this.metaAuthor = metaAuthor;
        this.metaDate = metaDate;
        this.metaTag = metaTag;
    }

    public MetaDataDto(MetaData metaData){
        metaData.setMetaGeoLocation(metaData.getMetaGeoLocation());
        metaData.setMetaAuthor(metaData.getMetaAuthor());
        metaData.setMetaDate(metaData.getMetaDate());
        metaData.setMetaTag(metaData.getMetaTag());
    }

    public String getMetaGeoLocation() {
        return metaGeoLocation;
    }

    public void setMetaGeoLocation(String metaGeoLocation) {
        this.metaGeoLocation = metaGeoLocation;
    }

    public String getMetaAuthor() {
        return metaAuthor;
    }

    public void setMetaAuthor(String metaAuthor) {
        this.metaAuthor = metaAuthor;
    }

    public LocalDate getMetaDate() {
        return metaDate;
    }

    public void setMetaDate(LocalDate metaDate) {
        this.metaDate = metaDate;
    }

    public String getMetaTag() {
        return metaTag;
    }

    public void setMetaTag(String metaTag) {
        this.metaTag = metaTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaDataDto that = (MetaDataDto) o;
        return Objects.equals(metaGeoLocation, that.metaGeoLocation) && Objects.equals(metaAuthor, that.metaAuthor) && Objects.equals(metaDate, that.metaDate) && Objects.equals(metaTag, that.metaTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaGeoLocation, metaAuthor, metaDate, metaTag);
    }

    @Override
    public String toString() {
        return "MetaDataDto{" +
                "metaGeoLocation='" + metaGeoLocation + '\'' +
                ", metaAuthor='" + metaAuthor + '\'' +
                ", metaDate=" + metaDate +
                ", metaTag='" + metaTag + '\'' +
                '}';
    }
}
