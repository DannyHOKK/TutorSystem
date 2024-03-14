package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TutorMatchStudentCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "STUDENT_CASE_ID", referencedColumnName = "CASE_ID")
    private StudentCase studentCase;
    @ManyToOne
    @JoinColumn(name = "TUTOR_ID", referencedColumnName = "id")
    private TutorUser tutorUser;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
    @Column(name = "STATUS")
    private String status;

    public TutorMatchStudentCase() {
    }

    public TutorMatchStudentCase(StudentCase studentCase, TutorUser tutorUser, Date createDate, Date modifyDate, String status) {
        this.studentCase = studentCase;
        this.tutorUser = tutorUser;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentCase getStudentCase() {
        return studentCase;
    }

    public void setStudentCase(StudentCase studentCase) {
        this.studentCase = studentCase;
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
