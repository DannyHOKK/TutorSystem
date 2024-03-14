package com.TutorCentres.TutorSystem.core.dto;

import java.time.LocalDate;

public class StudentRegisterDTO {

    private String email;
    private String password;
    private String identity;
    private String engName;
    private String chineseName;
    private String phone;
    private String gender;
    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StudentRegisterDTO(String email, String password, String identity, String engName, String chineseName, String phone, String gender, String address) {
        this.email = email;
        this.password = password;
        this.identity = identity;
        this.engName = engName;
        this.chineseName = chineseName;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }
}
