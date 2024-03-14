package com.TutorCentres.TutorSystem.core.vo;

import com.TutorCentres.TutorSystem.core.entity.TutorUser;

import java.util.Date;

public interface StudentCaseMatchingVO {

    Integer getCaseId();
    String getAddress();
    Date getCreateDate();
    String getDetailsAddress();
    Integer getTutorId();
}

