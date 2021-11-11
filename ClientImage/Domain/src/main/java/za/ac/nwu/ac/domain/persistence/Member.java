package za.ac.nwu.ac.domain.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "member", schema = "imageclient")
public class Member implements Serializable {

    private static final long serialVersionUID = -3737000646797959541L;

    private Long memberID;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String password;

    private Set<Photo> photo;

    public Member() {
    }


    public Member(Long memberID, String fname, String lname, String email, String phone, String password) {
        this.memberID = memberID;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Member(String fname, String lname, String email, String phone, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name = "member_fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Column(name = "member_lname")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Column(name = "member_email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "member_phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "member_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @OneToMany(targetEntity = Photo.class, fetch = FetchType.LAZY, mappedBy = "member")
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
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(fname, member.fname) && Objects.equals(lname, member.lname) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(password, member.password) && Objects.equals(photo, member.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, fname, lname, email, phone, password, photo);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", photo=" + photo +
                '}';
    }
}
