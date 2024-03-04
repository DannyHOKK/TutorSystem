package com.TutorCentres.TutorSystem.core.dto;

import java.util.List;

public class StudentCaseSearchDTO {

    private String tutorCategory;
    private List<String> tutorContent;
    private String tutorGender;
    private String studentLevelType;
    private List<String> studentLevel;
    private Integer lowestSalary;
    private Integer maxSalary;

    public String getTutorCategory() {
        return tutorCategory;
    }

    public void setTutorCategory(String tutorCategory) {
        this.tutorCategory = tutorCategory;
    }

    public List<String> getTutorContent() {
        return tutorContent;
    }

    public void setTutorContent(List<String> tutorContent) {
        this.tutorContent = tutorContent;
    }

    public String getTutorGender() {
        return tutorGender;
    }

    public void setTutorGender(String tutorGender) {
        this.tutorGender = tutorGender;
    }

    public String getStudentLevelType() {
        return studentLevelType;
    }

    public void setStudentLevelType(String studentLevelType) {
        this.studentLevelType = studentLevelType;
    }

    public List<String> getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(List<String> studentLevel) {
        this.studentLevel = studentLevel;
    }

    public Integer getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(Integer lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }
}