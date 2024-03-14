package com.TutorCentres.TutorSystem.core.dto;

public class StudentMatchTutorDTO {
    private Integer tutorId;
    private String studentLevelType;
    private String studentLevel;
    private Integer salary;
    private String tutorContent;
    private String tutorMethod;
    private String address;


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

    public Integer getTutorId() {
        return tutorId;
    }

    public void setTutorId(Integer tutorId) {
        this.tutorId = tutorId;
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
}
