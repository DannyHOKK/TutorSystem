package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String email;
    private String password;
    private Date createDate;
    private String role;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AdminUser() {
    }

    public AdminUser(String email, String password, Date createDate, String role) {
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.role = role;
    }
}
