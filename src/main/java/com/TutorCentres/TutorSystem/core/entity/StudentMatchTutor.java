package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StudentMatchTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "STUDENT_USER_ID", referencedColumnName = "id")
    private StudentUser studentUser;
    @ManyToOne
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "id")
    private TutorUser tutorUser;
    private String studentLevelType;
    private String studentLevel;
    private Integer salary;
    private String tutorContent;
    private String tutorMethod;
    private String address;
    private Date createDate;
    private Date modifyDate;
    private String status;

    public StudentMatchTutor() {
    }

    public StudentMatchTutor(StudentUser studentUser, TutorUser tutorUser, String studentLevelType, String studentLevel, Integer salary, String tutorContent, String tutorMethod, String address, Date createDate, Date modifyDate, String status) {
        this.studentUser = studentUser;
        this.tutorUser = tutorUser;
        this.studentLevelType = studentLevelType;
        this.studentLevel = studentLevel;
        this.salary = salary;
        this.tutorContent = tutorContent;
        this.tutorMethod = tutorMethod;
        this.address = address;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.status = status;
    }

    public String getStudentLevelType() {
        return studentLevelType;
    }

    public void setStudentLevelType(String studentLevelType) {
        this.studentLevelType = studentLevelType;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getTutorContent() {
        return tutorContent;
    }

    public void setTutorContent(String tutorContent) {
        this.tutorContent = tutorContent;
    }

    public String getTutorMethod() {
        return tutorMethod;
    }

    public void setTutorMethod(String tutorMethod) {
        this.tutorMethod = tutorMethod;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentUser getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(StudentUser studentUser) {
        this.studentUser = studentUser;
    }

    public TutorUser getTutorUser() {
        return tutorUser;
    }

    public void setTutorUser(TutorUser tutorUser) {
        this.tutorUser = tutorUser;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
