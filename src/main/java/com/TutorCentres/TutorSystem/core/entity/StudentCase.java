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
    @Column(name = "TUTOR_CATEGORY")
    private String tutorCategory;
    @Column(name = "TUTOR_CONTENT")
    private String tutorContent;
    @Column(name = "TUTOR_METHOD")
    private String tutorMethod;
    @Column(name = "TUTOR_REMARK")
    private String tutorRemark;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "STUDENT_LEVEL")
    private String studentLevel;
    @Column(name = "STUDENT_LEVEL_TYPE")
    private String studentLevelType;
    @Column(name = "MAX_SALARY")
    private Integer maxSalary;
    @Column(name = "MIN_SALARY")
    private Integer minSalary;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "DETAILS_ADDRESS")
    private String detailsAddress;
    @Column(name = "LESSON_PER_WEEK")
    private String lessonPerWeek;
    @Column(name = "LESSON_DURATION")
    private String lessonDuration;
    @Column(name = "TIMESLOT")
    private String timeslot;
    @Column(name = "TUTOR_REQUEST")
    private String tutorRequest;
    @Column(name = "CLOSE")
    private Boolean close;


    public StudentCase() {
    }

    public StudentCase(Date createDate, Date modifyDate, String tutorCategory, String tutorContent, String tutorMethod, String tutorRemark, String gender, String studentLevel, String studentLevelType, Integer maxSalary, Integer minSalary, String address, String detailsAddress, String lessonPerWeek, String lessonDuration, String timeslot, String tutorRequest, Boolean close) {
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.tutorCategory = tutorCategory;
        this.tutorContent = tutorContent;
        this.tutorMethod = tutorMethod;
        this.tutorRemark = tutorRemark;
        this.gender = gender;
        this.studentLevel = studentLevel;
        this.studentLevelType = studentLevelType;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.address = address;
        this.detailsAddress = detailsAddress;
        this.lessonPerWeek = lessonPerWeek;
        this.lessonDuration = lessonDuration;
        this.timeslot = timeslot;
        this.tutorRequest = tutorRequest;
        this.close = close;
    }

    public StudentCase(StudentCaseDTO studentCaseDTO) {
        this.tutorCategory = studentCaseDTO.getTutorCategory();
        this.tutorContent = studentCaseDTO.getTutorContent();
        this.tutorMethod = studentCaseDTO.getTutorMethod();
        this.tutorRemark = studentCaseDTO.getTutorRemark();
        this.gender = studentCaseDTO.getGender();
        this.studentLevel = studentCaseDTO.getStudentLevel();
        this.studentLevelType = studentCaseDTO.getStudentLevelType();
        this.maxSalary = studentCaseDTO.getMaxSalary();
        this.minSalary = studentCaseDTO.getMinSalary();
        this.address = studentCaseDTO.getAddress();
        this.detailsAddress = studentCaseDTO.getDetailsAddress();
        this.lessonPerWeek = studentCaseDTO.getLessonPerWeek();
        this.lessonDuration = studentCaseDTO.getLessonDuration();
        this.timeslot = studentCaseDTO.getTimeslot();
        this.tutorRequest = studentCaseDTO.getTutorRequest();
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

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getTutorCategory() {
        return tutorCategory;
    }

    public void setTutorCategory(String tutorCategory) {
        this.tutorCategory = tutorCategory;
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

    public String getTutorRemark() {
        return tutorRemark;
    }

    public void setTutorRemark(String tutorRemark) {
        this.tutorRemark = tutorRemark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getStudentLevelType() {
        return studentLevelType;
    }

    public void setStudentLevelType(String studentLevelType) {
        this.studentLevelType = studentLevelType;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }

    public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
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

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getTutorRequest() {
        return tutorRequest;
    }

    public void setTutorRequest(String tutorRequest) {
        this.tutorRequest = tutorRequest;
    }

    public Boolean getClose() {
        return close;
    }

    public void setClose(Boolean close) {
        this.close = close;
    }
}
