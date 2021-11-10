package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.MetaData;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MetaDataDto implements Serializable {

    private static final long serialVersionUID = -1060158268568159328L;

    private String metafileName;
    private String metaSize;
    private LocalDate metaDate;
    private String metaFileType;

    public MetaDataDto() {
    }

    public MetaDataDto(String metafileName, String metaSize, LocalDate metaDate, String metaFileType) {
        this.metafileName = metafileName;
        this.metaSize = metaSize;
        this.metaDate = metaDate;
        this.metaFileType = metaFileType;
    }

    public MetaDataDto(MetaData metaData){
        metaData.setMetaFileName(metaData.getMetaFileName());
        metaData.setMetaSize(metaData.getMetaSize());
        metaData.setMetaDate(metaData.getMetaDate());
        metaData.setMetaFileType(metaData.getMetaFileType());
    }

    public String getMetafileName() {
        return metafileName;
    }

    public void setMetafileName(String metafileName) {
        this.metafileName = metafileName;
    }

    public String getMetaSize() {
        return metaSize;
    }

    public void setMetaSize(String metaSize) {
        this.metaSize = metaSize;
    }

    public LocalDate getMetaDate() {
        return metaDate;
    }

    public void setMetaDate(LocalDate metaDate) {
        this.metaDate = metaDate;
    }

    public String getMetaFileType() {
        return metaFileType;
    }

    public void setMetaFileType(String metaFileType) {
        this.metaFileType = metaFileType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaDataDto that = (MetaDataDto) o;
        return Objects.equals(metafileName, that.metafileName) && Objects.equals(metaSize, that.metaSize) && Objects.equals(metaDate, that.metaDate) && Objects.equals(metaFileType, that.metaFileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metafileName, metaSize, metaDate, metaFileType);
    }

    @Override
    public String toString() {
        return "MetaDataDto{" +
                "metafileName='" + metafileName + '\'' +
                ", metaSize='" + metaSize + '\'' +
                ", metaDate=" + metaDate +
                ", metaFileType='" + metaFileType + '\'' +
                '}';
    }
}
