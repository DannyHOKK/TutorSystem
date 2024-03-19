package com.TutorCentres.TutorSystem.core.dto;

import com.TutorCentres.TutorSystem.core.entity.ExamResult;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TutorRegisterDTO {

    private String email;
    private String password;
    private String engName;
    private String chineseName;
    private String phone;
    private String hkId;
    private String gender;
    private LocalDate birthYear;
    private String address;
    private String currentJob;
    private String workExperience;
    private String highestTutorLevel;
    private Boolean noteProvided;
    private String highSchoolLang;
    private String highSchool;
    private String highSchoolMajor;
    private String highestEducation;
    private String university;
    private String currentEducationLevel;
    private String universityMajor;
    private String hkOpenExam;
    private List<String> tutorAreas;
    private List<String> tutorContent;
    private List<String> tutorLevel;
    private List<String> tutorSpeaking;

    private List<String> tutorMusic;

    private List<String> tutorOtherLevel;
    private Integer lowestSalary;
    private Integer idealSalary;
    private String examResult;
    private String introTitle;
    private String intro;

    public TutorRegisterDTO() {
    }

    public TutorRegisterDTO(String email, String password, String engName, String chineseName, String phone, String hkId, String gender, LocalDate birthYear, String address, String currentJob, String workExperience, String highestTutorLevel, Boolean noteProvided, String highSchoolLang, String highSchool, String highSchoolMajor, String highestEducation, String university, String currentEducationLevel, String universityMajor, String hkOpenExam, List<String> tutorAreas, List<String> tutorContent, List<String> tutorLevel, List<String> tutorSpeaking, List<String> tutorMusic, List<String> tutorOtherLevel, Integer lowestSalary, Integer idealSalary, String examResult, String introTitle, String intro) {
        this.email = email;
        this.password = password;
        this.engName = engName;
        this.chineseName = chineseName;
        this.phone = phone;
        this.hkId = hkId;
        this.gender = gender;
        this.birthYear = birthYear;
        this.address = address;
        this.currentJob = currentJob;
        this.workExperience = workExperience;
        this.highestTutorLevel = highestTutorLevel;
        this.noteProvided = noteProvided;
        this.highSchoolLang = highSchoolLang;
        this.highSchool = highSchool;
        this.highSchoolMajor = highSchoolMajor;
        this.highestEducation = highestEducation;
        this.university = university;
        this.currentEducationLevel = currentEducationLevel;
        this.universityMajor = universityMajor;
        this.hkOpenExam = hkOpenExam;
        this.tutorAreas = tutorAreas;
        this.tutorContent = tutorContent;
        this.tutorLevel = tutorLevel;
        this.tutorSpeaking = tutorSpeaking;
        this.tutorMusic = tutorMusic;
        this.tutorOtherLevel = tutorOtherLevel;
        this.lowestSalary = lowestSalary;
        this.idealSalary = idealSalary;
        this.examResult = examResult;
        this.introTitle = introTitle;
        this.intro = intro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHkId() {
        return hkId;
    }

    public void setHkId(String hkId) {
        this.hkId = hkId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(LocalDate birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getHighestTutorLevel() {
        return highestTutorLevel;
    }

    public void setHighestTutorLevel(String highestTutorLevel) {
        this.highestTutorLevel = highestTutorLevel;
    }

    public Boolean getNoteProvided() {
        return noteProvided;
    }

    public void setNoteProvided(Boolean noteProvided) {
        this.noteProvided = noteProvided;
    }

    public String getHighSchoolLang() {
        return highSchoolLang;
    }

    public void setHighSchoolLang(String highSchoolLang) {
        this.highSchoolLang = highSchoolLang;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public String getHighSchoolMajor() {
        return highSchoolMajor;
    }

    public void setHighSchoolMajor(String highSchoolMajor) {
        this.highSchoolMajor = highSchoolMajor;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCurrentEducationLevel() {
        return currentEducationLevel;
    }

    public void setCurrentEducationLevel(String currentEducationLevel) {
        this.currentEducationLevel = currentEducationLevel;
    }

    public String getUniversityMajor() {
        return universityMajor;
    }

    public void setUniversityMajor(String universityMajor) {
        this.universityMajor = universityMajor;
    }

    public String getHkOpenExam() {
        return hkOpenExam;
    }

    public void setHkOpenExam(String hkOpenExam) {
        this.hkOpenExam = hkOpenExam;
    }

    public List<String> getTutorAreas() {
        return tutorAreas;
    }

    public void setTutorAreas(List<String> tutorAreas) {
        this.tutorAreas = tutorAreas;
    }

    public List<String> getTutorContent() {
        return tutorContent;
    }

    public void setTutorContent(List<String> tutorContent) {
        this.tutorContent = tutorContent;
    }

    public List<String> getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(List<String> tutorLevel) {
        this.tutorLevel = tutorLevel;
    }

    public List<String> getTutorSpeaking() {
        return tutorSpeaking;
    }

    public void setTutorSpeaking(List<String> tutorSpeaking) {
        this.tutorSpeaking = tutorSpeaking;
    }

    public List<String> getTutorMusic() {
        return tutorMusic;
    }

    public void setTutorMusic(List<String> tutorMusic) {
        this.tutorMusic = tutorMusic;
    }

    public List<String> getTutorOtherLevel() {
        return tutorOtherLevel;
    }

    public void setTutorOtherLevel(List<String> tutorOtherLevel) {
        this.tutorOtherLevel = tutorOtherLevel;
    }

    public Integer getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(Integer lowestSalary) {
        this.lowestSalary = lowestSalary;
    }

    public Integer getIdealSalary() {
        return idealSalary;
    }

    public void setIdealSalary(Integer idealSalary) {
        this.idealSalary = idealSalary;
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
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
}
