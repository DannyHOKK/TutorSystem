package com.TutorCentres.TutorSystem.core.dto;

import javax.persistence.Column;

public class StudentCaseDTO {

    private String tutorCategory;
    private String tutorContent;
    private String tutorMethod;
    private String tutorRemark;
    private String gender;
    private String studentLevel;
    private String studentLevelType;
    private Integer maxSalary;
    private Integer minSalary;
    private String address;
    private String detailsAddress;
    private String lessonPerWeek;
    private String lessonDuration;
    private String timeslot;
    private String tutorRequest;

    public StudentCaseDTO(String tutorCategory, String tutorContent, String tutorMethod, String tutorRemark, String gender, String studentLevel, String studentLevelType, Integer maxSalary, Integer minSalary, String address, String detailsAddress, String lessonPerWeek, String lessonDuration, String timeslot, String tutorRequest) {
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
}
