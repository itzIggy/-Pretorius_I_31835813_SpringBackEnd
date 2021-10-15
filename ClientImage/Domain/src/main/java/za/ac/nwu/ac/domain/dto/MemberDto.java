package za.ac.nwu.ac.domain.dto;


import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.util.Objects;

public class MemberDto implements Serializable {

    private static final long serialVersionUID = -3675411777951570019L;

    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String password;

    public MemberDto() {
    }

    public MemberDto(String fname, String lname, String email, String phone, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public MemberDto(Member member){
        this.setFname(member.getFname());
        this.setLname(member.getLname());
        this.setEmail(member.getEmail());
        this.setPhone(member.getPhone());
        this.setPassword(member.getPassword());
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(fname, memberDto.fname) && Objects.equals(lname, memberDto.lname) && Objects.equals(email, memberDto.email) && Objects.equals(phone, memberDto.phone) && Objects.equals(password, memberDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, email, phone, password);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
