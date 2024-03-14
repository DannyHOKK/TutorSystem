package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(name = "StudentCaseMappingEntity",
        entities = {
                @EntityResult(entityClass = StudentCaseMappingEntity.class,
                        fields = {
                                @FieldResult(name = "caseId", column = "CASE_ID"),
                                @FieldResult(name = "tutorGender", column = "TUTOR_GENDER"),
                                @FieldResult(name = "tutorCategory", column = "TUTOR_CATEGORY"),
                                @FieldResult(name = "tutorContent", column = "TUTOR_CONTENT"),
                                @FieldResult(name = "tutorMethod", column = "TUTOR_METHOD"),
                                @FieldResult(name = "tutorRemark", column = "TUTOR_REMARK"),
                                @FieldResult(name = "gender", column = "GENDER"),
                                @FieldResult(name = "studentLevel", column = "STUDENT_LEVEL"),
                                @FieldResult(name = "studentLevelType", column = "STUDENT_LEVEL_TYPE"),
                                @FieldResult(name = "maxSalary", column = "MAX_SALARY"),
                                @FieldResult(name = "minSalary", column = "MIN_SALARY"),
                                @FieldResult(name = "address", column = "ADDRESS"),
                                @FieldResult(name = "detailsAddress", column = "DETAILS_ADDRESS"),
                                @FieldResult(name = "lessonPerWeek", column = "LESSON_PER_WEEK"),
                                @FieldResult(name = "lessonDuration", column = "LESSON_DURATION"),
                                @FieldResult(name = "timeslot", column = "TIMESLOT"),
                                @FieldResult(name = "tutorRequest", column = "TUTOR_REQUEST"),
                        })
        })
public class StudentCaseMappingEntity {
    @Id
    private Integer caseId;
    private String tutorGender;
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

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getTutorGender() {
        return tutorGender;
    }

    public void setTutorGender(String tutorGender) {
        this.tutorGender = tutorGender;
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
