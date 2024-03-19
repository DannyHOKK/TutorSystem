package com.TutorCentres.TutorSystem.core.vo;

import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;

import java.util.Date;

public interface StudentCaseMatchingVO {

    Integer getCaseId();
    Date getCreateDate();
    Date getModifyDate();
    String getTutorRequestGender();
    String getTutorCategory();
    String getTutorContent();
    String getTutorMethod();
    String getTutorRemark();
    String getGender();
    String getStudentLevel();
    String getStudentLevelType();
    Integer getMaxSalary();
    Integer getMinSalary();
    String getAddress();
    String getDetailsAddress();
    String getLessonPerWeek();
    String getLessonDuration();
    String getTimeslot();
    String getStatus();
    String getEngName();
    String getTutorGender();
    String getCurrentJob();
    String getWorkExperience();
    String getHighestTutorLevel();
    Boolean getNoteProvided();
    String getUniversity();
    String getUniversityMajor();
    String getCurrentEducationLevel();
    String getCaseStatus();
    String getCaseCreateDate();
    String getCaseModifyDate();
    Integer getTutorId();
    Integer getTutorMatchCaseId();
}
