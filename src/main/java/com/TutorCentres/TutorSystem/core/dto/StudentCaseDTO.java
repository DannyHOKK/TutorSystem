package com.TutorCentres.TutorSystem.core.dto;

import javax.persistence.Column;

public class StudentCaseDTO {

    private String tutorCategory;
    private String subject;
    private String studentLevel;
    private Integer tutorFee;
    private String location;
    private String locationDetails;
    private String lessonPerWeek;
    private String lessonDuration;
    private String timeAvailable;
    private String tutorRequire;

    public String getTutorCategory() {
        return tutorCategory;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public void setTutorCategory(String tutorCategory) {
        this.tutorCategory = tutorCategory;
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

    public StudentCaseDTO(String subject, Integer tutorFee, String location, String locationDetails, String lessonPerWeek, String lessonDuration, String timeAvailable, String tutorRequire) {
        this.subject = subject;
        this.tutorFee = tutorFee;
        this.location = location;
        this.locationDetails = locationDetails;
        this.lessonPerWeek = lessonPerWeek;
        this.lessonDuration = lessonDuration;
        this.timeAvailable = timeAvailable;
        this.tutorRequire = tutorRequire;
    }
}
