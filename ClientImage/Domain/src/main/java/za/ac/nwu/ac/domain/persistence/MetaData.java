package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "metadata", schema = "imageclient")
public class MetaData implements Serializable{

    private static final long serialVersionUID = -2291190826579963737L;

    private Long metaID;
    private String metaFileName;
    private String metaSize;
    private LocalDate metaDate;
    private String metaFileType;

    public MetaData() {
    }

    public MetaData(Long metaID, String metaFileName, String metaSize, LocalDate metaDate, String metaFileType) {
        this.metaID = metaID;
        this.metaFileName = metaFileName;
        this.metaSize = metaSize;
        this.metaDate = metaDate;
        this.metaFileType = metaFileType;
    }

    public MetaData(String metaFileName, String metaSize, LocalDate metaDate, String metaFileType) {
        this.metaFileName = metaFileName;
        this.metaSize = metaSize;
        this.metaDate = metaDate;
        this.metaFileType = metaFileType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meta_ID")
    public Long getMetaID() {
        return metaID;
    }

    public void setMetaID(Long metaID) {
        this.metaID = metaID;
    }

    @Column(name = "meta_filename")
    public String getMetaFileName() {
        return metaFileName;
    }

    public void setMetaFileName(String metaFileName) {
        this.metaFileName = metaFileName;
    }

    @Column(name = "meta_filesize")
    public String getMetaSize() {
        return metaSize;
    }

    public void setMetaSize(String metaSize) {
        this.metaSize = metaSize;
    }

    @Column(name = "meta_date")
    public LocalDate getMetaDate() {
        return metaDate;
    }

    public void setMetaDate(LocalDate metaDate) {
        this.metaDate = metaDate;
    }

    @Column(name = "meta_filetype")
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
        MetaData metaData = (MetaData) o;
        return Objects.equals(metaID, metaData.metaID) && Objects.equals(metaFileName, metaData.metaFileName) && Objects.equals(metaSize, metaData.metaSize) && Objects.equals(metaDate, metaData.metaDate) && Objects.equals(metaFileType, metaData.metaFileType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metaID, metaFileName, metaSize, metaDate, metaFileType);
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "metaID=" + metaID +
                ", metaFileName='" + metaFileName + '\'' +
                ", metaSize='" + metaSize + '\'' +
                ", metaDate=" + metaDate +
                ", metaFileType='" + metaFileType + '\'' +
                '}';
    }
}
