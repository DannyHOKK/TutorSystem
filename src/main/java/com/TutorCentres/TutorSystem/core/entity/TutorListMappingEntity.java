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
                                @FieldResult(name = "gender", column = "GENDER"),
                                @FieldResult(name = "tutorContent", column = "TUTOR_CONTENT"),
                                @FieldResult(name = "tutorLevel", column = "TUTOR_LEVEL"),
                                @FieldResult(name = "tutorMusicLevel", column = "TUTOR_MUSIC_LEVEL"),
                                @FieldResult(name = "tutorSpeakingLevel", column = "TUTOR_SPEAKING_LEVEL"),
                                @FieldResult(name = "tutorOtherLevel", column = "TUTOR_OTHER_LEVEL"),
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
public class TutorListMappingEntity implements Serializable {

    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ENG_NAME")
    private String engName;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "TUTOR_CONTENT")
    private String tutorContent;
    @Column(name = "TUTOR_LEVEL")
    private String tutorLevel;
    @Column(name = "TUTOR_MUSIC_LEVEL")
    private String tutorMusicLevel;
    @Column(name = "TUTOR_SPEAKING_LEVEL")
    private String tutorSpeakingLevel;
    @Column(name = "TUTOR_OTHER_LEVEL")
    private String tutorOtherLevel;
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
    @Column(name = "UNIVERSITY_MAJOR")
    private String universityMajor;
    @Column(name = "INTRO_TITLE")
    private String introTitle;
    @Column(name = "INTRO")
    private String intro;


    public TutorListMappingEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTutorMusicLevel() {
        return tutorMusicLevel;
    }

    public void setTutorMusicLevel(String tutorMusicLevel) {
        this.tutorMusicLevel = tutorMusicLevel;
    }

    public String getTutorSpeakingLevel() {
        return tutorSpeakingLevel;
    }

    public void setTutorSpeakingLevel(String tutorSpeakingLevel) {
        this.tutorSpeakingLevel = tutorSpeakingLevel;
    }

    public String getTutorOtherLevel() {
        return tutorOtherLevel;
    }

    public void setTutorOtherLevel(String tutorOtherLevel) {
        this.tutorOtherLevel = tutorOtherLevel;
    }

    public String getIntroTitle() {
        return introTitle;
    }

    public void setIntroTitle(String introTitle) {
        this.introTitle = introTitle;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUniversityMajor() {
        return universityMajor;
    }

    public void setUniversityMajor(String universityMajor) {
        this.universityMajor = universityMajor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(String tutorLevel) {
        this.tutorLevel = tutorLevel;
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
