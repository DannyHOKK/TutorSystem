package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StudentMapTutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "STUDENT_USER_ID", referencedColumnName = "id")
    private StudentUser studentUser;
    @ManyToOne
    @JoinColumn(name = "TUTOR_USER_ID", referencedColumnName = "id")
    private TutorUser tutorUser;
    private Date createDate;
    private Date modifyDate;
    private String status;

    public StudentMapTutor() {
    }

    public StudentMapTutor(StudentUser studentUser, TutorUser tutorUser, Date createDate, Date modifyDate, String status) {
        this.studentUser = studentUser;
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
