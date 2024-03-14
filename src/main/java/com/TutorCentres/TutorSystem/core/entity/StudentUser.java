package com.TutorCentres.TutorSystem.core.entity;

import com.TutorCentres.TutorSystem.core.dto.StudentRegisterDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "student_user")
public class StudentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "identity")
    private String identity;
    @Column(name = "roles")
    private String roles;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "modify_date")
    private Date modifyDate;
    @Column(name = "eng_name")
    private String engName;
    @Column(name = "chinese_name")
    private String chineseName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;

    public StudentUser() {
    }


    public StudentUser(String email, String password, String identity, String roles, Date createDate, Date modifyDate, String engName, String chineseName, String phone, String gender, String address) {
        this.email = email;
        this.password = password;
        this.identity = identity;
        this.roles = roles;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.engName = engName;
        this.chineseName = chineseName;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
    }

    public StudentUser(StudentRegisterDTO studentRegisterDTO) {
        this.email = studentRegisterDTO.getEmail();
        this.identity = studentRegisterDTO.getIdentity();
        this.engName = studentRegisterDTO.getEngName();
        this.chineseName = studentRegisterDTO.getChineseName();
        this.phone = studentRegisterDTO.getPhone();
        this.gender = studentRegisterDTO.getGender();
        this.address = studentRegisterDTO.getAddress();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
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
}
