package com.TutorCentres.TutorSystem.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@SqlResultSetMapping(name = "TutorListMappingEntity",
        entities = {
                @EntityResult(entityClass = TutorListMappingEntity.class,
                        fields = {
                                @FieldResult(name = "id", column = "ID"),
                                @FieldResult(name = "engName", column = "ENG_NAME"),
                                @FieldResult(name = "tutorContent", column = "TUTOR_CONTENT"),
                                @FieldResult(name = "tutorLevel", column = "TUTOR_LEVEL"),
                                @FieldResult(name = "tutorAreas", column = "TUTOR_AREAS"),
                                @FieldResult(name = "lowestSalary", column = "LOWEST_SALARY"),
                                @FieldResult(name = "university", column = "UNIVERSITY"),
                                @FieldResult(name = "highestEducation", column = "HIGHEST_EDUCATION"),
                                @FieldResult(name = "highestTutorLevel", column = "HIGHEST_TUTOR_LEVEL"),
                        })
        })
public class TutorListMappingEntity implements Serializable {

    @Id
    private Integer id;
    @Column(name = "ENG_NAME")
    private String engName;
    @Column(name = "TUTOR_CONTENT")
    private String tutorContent;
    @Column(name = "TUTOR_LEVEL")
    private String tutorLevel;
    @Column(name = "TUTOR_AREAS")
    private String tutorAreas;
    @Column(name = "LOWEST_SALARY")
    private Integer lowestSalary;
    @Column(name = "UNIVERSITY")
    private String university;
    @Column(name = "HIGHEST_EDUCATION")
    private String highestEducation;
    @Column(name = "HIGHEST_TUTOR_LEVEL")
    private String highestTutorLevel;


    public TutorListMappingEntity() {
    }

    public String getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(String tutorLevel) {
        this.tutorLevel = tutorLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getTutorContent() {
        return tutorContent;
    }

    public void setTutorContent(String tutorContent) {
        this.tutorContent = tutorContent;
    }

    public String getTutorAreas() {
        return tutorAreas;
    }

    public void setTutorAreas(String tutorAreas) {
        this.tutorAreas = tutorAreas;
    }

    public Integer getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(Integer lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getHighestTutorLevel() {
        return highestTutorLevel;
    }

    public void setHighestTutorLevel(String highestTutorLevel) {
        this.highestTutorLevel = highestTutorLevel;
    }
}
