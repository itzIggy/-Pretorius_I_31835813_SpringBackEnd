package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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
    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name = "MEMBER_FNAME")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Column(name = "MEMBER_LNAME")
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Column(name = "MEMBER_EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "MEMBER_PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "MEMBER_PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(fname, member.fname) && Objects.equals(lname, member.lname) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone) && Objects.equals(password, member.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, fname, lname, email, phone, password);
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
                '}';
    }
}
