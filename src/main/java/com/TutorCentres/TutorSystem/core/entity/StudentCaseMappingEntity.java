package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(name = "StudentCaseMappingEntity",
        entities = {
                @EntityResult(entityClass = StudentCaseMappingEntity.class,
                        fields = {
                                @FieldResult(name = "caseId", column = "CASE_ID"),
                                @FieldResult(name = "engName", column = "ENG_NAME"),
                                @FieldResult(name = "gender", column = "GENDER"),
                                @FieldResult(name = "tutorContent", column = "TUTOR_CONTENT"),
                                @FieldResult(name = "tutorLevel", column = "TUTOR_LEVEL"),
                                @FieldResult(name = "tutorAreas", column = "TUTOR_AREAS"),
                                @FieldResult(name = "lowestSalary", column = "LOWEST_SALARY"),
                                @FieldResult(name = "university", column = "UNIVERSITY"),
                                @FieldResult(name = "highestEducation", column = "HIGHEST_EDUCATION"),
                                @FieldResult(name = "highestTutorLevel", column = "HIGHEST_TUTOR_LEVEL"),
                                @FieldResult(name = "universityMajor", column = "UNIVERSITY_MAJOR"),
                                @FieldResult(name = "introTitle", column = "INTRO_TITLE"),
                                @FieldResult(name = "intro", column = "INTRO"),
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
}
