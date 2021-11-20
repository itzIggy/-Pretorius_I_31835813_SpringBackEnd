package za.ac.nwu.ac.domain.dto;

import za.ac.nwu.ac.domain.persistence.MetaData;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class MetaDataDto implements Serializable {

    private static final long serialVersionUID = -1060158268568159328L;

    private Long metaSize;
    private String metaType;

    public MetaDataDto() {
    }

    public MetaDataDto(Long metaSize, String metaType) {
        this.metaSize = metaSize;
        this.metaType = metaType;
    }

    public MetaDataDto(MetaData metaData){
        metaData.setMetaSize(metaData.getMetaSize());
        metaData.setMetaType(metaData.getMetaType());
    }

    public Long getMetaSize() {
        return metaSize;
    }

    public void setMetaSize(Long metaSize) {
        this.metaSize = metaSize;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaDataDto that = (MetaDataDto) o;
        return Objects.equals(metaSize, that.metaSize) && Objects.equals(metaType, that.metaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaSize, metaType);
    }

    @Override
    public String toString() {
        return "MetaDataDto{" +
                "metaSize='" + metaSize + '\'' +
                ", metaType='" + metaType + '\'' +
                '}';
    }
}
