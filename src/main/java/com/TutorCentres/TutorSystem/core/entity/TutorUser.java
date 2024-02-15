package com.TutorCentres.TutorSystem.core.entity;

import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tutor_user")
public class TutorUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "roles")
    private String roles;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "modify_date")
    private Date modifyDate;
    @Column(name = "eng_name")
    private String engName;
    @Column(name = "chinese_name")
    private String chineseName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "hk_id")
    private String hkId;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birth_year")
    private LocalDate birthYear;
    @Column(name = "address")
    private String address;
    @Column(name = "current_job")
    private String currentJob;
    @Column(name = "work_experience")
    private String workExperience;
    @Column(name = "highest_tutor_level")
    private String highestTutorLevel;
    @Column(name = "note_provided")
    private Boolean noteProvided;
    @Column(name = "high_school_lang")
    private String highSchoolLang;
    @Column(name = "high_school")
    private String highSchool;
    @Column(name = "high_school_major")
    private String highSchoolMajor;
    @Column(name = "highest_education")
    private String highestEducation;
    @Column(name = "university")
    private String university;
    @Column(name = "current_education_leve")
    private String currentEducationLevel;
    @Column(name = "university_major")
    private String universityMajor;
    @Column(name = "hk_open_exam")
    private String hkOpenExam;

    @Column(name = "tutor_areas")
    private String tutorAreas;

    @Column(name = "tutor_content")
    private String tutorContent;

    @Column(name = "tutor_level")
    private String tutorLevel;

    @Column(name = "tutor_speaking_level")
    private String tutorSpeaking;

    @Column(name = "tutor_music_level")
    private String tutorMusic;

    @Column(name = "tutor_other_level")
    private String tutorOtherLevel;
    @Column(name = "lowest_salary")
    private Integer lowestSalary;
    @Column(name = "ideal_salary")
    private Integer idealSalary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "open_exam_result")
    private List<ExamResult> examResult;

    // Constructors, getters, and setters


    public TutorUser() {
    }

    public TutorUser( String email, String password, String roles, Date createDate, Date modifyDate, String engName, String chineseName, String phone, String hkId, String gender, LocalDate birthYear, String address, String currentJob, String workExperience, String highestTutorLevel, Boolean noteProvided, String highSchoolLang, String highSchool, String highSchoolMajor, String highestEducation, String university, String currentEducationLevel, String universityMajor, String hkOpenExam, String tutorAreas, String tutorContent, String tutorLevel, String tutorSpeaking, String tutorMusic, String tutorOtherLevel, Integer lowestSalary, Integer idealSalary, List<ExamResult> examResult) {
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
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
    }

    public TutorUser(TutorRegisterDTO tutorRegisterDTO) {
        this.email = tutorRegisterDTO.getEmail();
//        this.password = tutorRegisterDTO.getPassword();
        this.engName = tutorRegisterDTO.getEngName();
        this.chineseName = tutorRegisterDTO.getChineseName();
        this.phone = tutorRegisterDTO.getPhone();
        this.hkId = tutorRegisterDTO.getHkId();
        this.gender = tutorRegisterDTO.getGender();
        this.birthYear = tutorRegisterDTO.getBirthYear();
        this.address = tutorRegisterDTO.getAddress();
        this.currentJob = tutorRegisterDTO.getCurrentJob();
        this.workExperience = tutorRegisterDTO.getWorkExperience();
        this.highestTutorLevel = tutorRegisterDTO.getHighestTutorLevel();
        this.noteProvided = tutorRegisterDTO.getNoteProvided();
        this.highSchoolLang = tutorRegisterDTO.getHighSchoolLang();
        this.highSchool = tutorRegisterDTO.getHighSchool();
        this.highSchoolMajor = tutorRegisterDTO.getHighSchoolMajor();
        this.highestEducation = tutorRegisterDTO.getHighestEducation();
        this.university = tutorRegisterDTO.getUniversity();
        this.currentEducationLevel = tutorRegisterDTO.getCurrentEducationLevel();
        this.universityMajor = tutorRegisterDTO.getUniversityMajor();
        this.hkOpenExam = tutorRegisterDTO.getHkOpenExam();
//        this.tutorAreas = tutorAreas;
//        this.tutorContent = tutorContent;
//        this.tutorLevel = tutorLevel;
//        this.tutorSpeaking = tutorSpeaking;
//        this.tutorMusic = tutorMusic;
//        this.tutorOtherLevel = tutorOtherLevel;
        this.lowestSalary = tutorRegisterDTO.getLowestSalary();
        this.idealSalary = tutorRegisterDTO.getIdealSalary();
//        this.examResult = examResult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public String getTutorAreas() {
        return tutorAreas;
    }

    public void setTutorAreas(String tutorAreas) {
        this.tutorAreas = tutorAreas;
    }

    public String getTutorContent() {
        return tutorContent;
    }

    public void setTutorContent(String tutorContent) {
        this.tutorContent = tutorContent;
    }

    public String getTutorLevel() {
        return tutorLevel;
    }

    public void setTutorLevel(String tutorLevel) {
        this.tutorLevel = tutorLevel;
    }

    public String getTutorSpeaking() {
        return tutorSpeaking;
    }

    public void setTutorSpeaking(String tutorSpeaking) {
        this.tutorSpeaking = tutorSpeaking;
    }

    public String getTutorMusic() {
        return tutorMusic;
    }

    public void setTutorMusic(String tutorMusic) {
        this.tutorMusic = tutorMusic;
    }

    public String getTutorOtherLevel() {
        return tutorOtherLevel;
    }

    public void setTutorOtherLevel(String tutorOtherLevel) {
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

    public List<ExamResult> getExamResult() {
        return examResult;
    }

    public void setExamResult(List<ExamResult> examResult) {
        this.examResult = examResult;
    }
}
