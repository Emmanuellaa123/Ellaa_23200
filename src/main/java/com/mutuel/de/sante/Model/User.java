package com.mutuel.de.sante.Model;

import jakarta.persistence.*;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String fName;
    private String lName;
    private String nationalId;
    private String address;
    private String socialStatus;
    private String headOfFamily;
    private String phoneNumber;
    private String email;

    public User() {
    }

    public User(Integer id, String fName, String lName, String nationalId, String address, String socialStatus, String headOfFamily, String phoneNumber, String email) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.nationalId = nationalId;
        this.address = address;
        this.socialStatus = socialStatus;
        this.headOfFamily = headOfFamily;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSocialStatus() {
        return socialStatus;
    }

    public void setSocialStatus(String socialStatus) {
        this.socialStatus = socialStatus;
    }

    public String getHeadOfFamily() {
        return headOfFamily;
    }

    public void setHeadOfFamily(String heardOfFamily) {
        this.headOfFamily = heardOfFamily;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", address='" + address + '\'' +
                ", socialStatus='" + socialStatus + '\'' +
                ", heardOfFamily='" + headOfFamily + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
