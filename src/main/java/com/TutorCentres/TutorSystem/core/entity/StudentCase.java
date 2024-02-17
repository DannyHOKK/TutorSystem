package com.TutorCentres.TutorSystem.core.entity;

import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_case")
public class StudentCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CASE_ID")
    private Integer caseId;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "TUTOR_FEE")
    private Integer tutorFee;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "LOCATION_DETAILS")
    private String locationDetails;
    @Column(name = "LESSON_PER_WEEK")
    private String lessonPerWeek;
    @Column(name = "LESSON_DURATION")
    private String lessonDuration;
    @Column(name = "TIME_AVAILABLE")
    private String timeAvailable;
    @Column(name = "TUTOR_REQUIRE")
    private String tutorRequire;
    @Column(name = "CLOSE")
    private Boolean close;


    public StudentCase() {
    }

    public StudentCase(StudentCaseDTO studentCaseDTO) {

        this.subject = studentCaseDTO.getSubject();
        this.tutorFee = studentCaseDTO.getTutorFee();
        this.location = studentCaseDTO.getLocation();
        this.locationDetails = studentCaseDTO.getLocationDetails();
        this.lessonPerWeek = studentCaseDTO.getLessonPerWeek();
        this.lessonDuration = studentCaseDTO.getLessonDuration();
        this.timeAvailable = studentCaseDTO.getTimeAvailable();
        this.tutorRequire = studentCaseDTO.getTutorRequire();
        this.close = false;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public StudentCase(Date createDate, Date modifyDate, String subject, Integer tutorFee, String location, String locationDetails, String lessonPerWeek, String lessonDuration, String timeAvailable, String tutorRequire, Boolean close) {
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.subject = subject;
        this.tutorFee = tutorFee;
        this.location = location;
        this.locationDetails = locationDetails;
        this.lessonPerWeek = lessonPerWeek;
        this.lessonDuration = lessonDuration;
        this.timeAvailable = timeAvailable;
        this.tutorRequire = tutorRequire;
        this.close = close;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getTutorFee() {
        return tutorFee;
    }

    public void setTutorFee(Integer tutorFee) {
        this.tutorFee = tutorFee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public String getLessonPerWeek() {
        return lessonPerWeek;
    }

    public void setLessonPerWeek(String lessonPerWeek) {
        this.lessonPerWeek = lessonPerWeek;
    }

    public String getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(String lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public String getTimeAvailable() {
        return timeAvailable;
    }

    public void setTimeAvailable(String timeAvailable) {
        this.timeAvailable = timeAvailable;
    }

    public String getTutorRequire() {
        return tutorRequire;
    }

    public void setTutorRequire(String tutorRequire) {
        this.tutorRequire = tutorRequire;
    }

    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }
}
