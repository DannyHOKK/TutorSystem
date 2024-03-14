package com.TutorCentres.TutorSystem.Tutor.service;

import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.entity.TutorListMappingEntity;
import com.TutorCentres.TutorSystem.core.entity.TutorMatchStudentCase;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;

import java.util.List;

public interface TutorUserService {
    String signUp(TutorRegisterDTO tutorUser);

    List<TutorListMappingEntity> queryTutorList(TutorSearchDTO tutorSearchDTO);

    TutorUser getTutorById(Integer tutorId);

    String editTutor(TutorRegisterDTO tutorRegisterDTO);

    String matchingStudentCase(Integer caseId);

    List<TutorMatchStudentCase> getMatchingCase(Integer tutorId);

    List<StudentMatchTutor> getStudentMatching();

    String cancelMatchingCase(Integer caseId);
}
