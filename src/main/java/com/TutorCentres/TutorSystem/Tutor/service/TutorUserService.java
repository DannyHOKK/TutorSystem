package com.TutorCentres.TutorSystem.Tutor.service;

import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.entity.TutorMatchStudentCase;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import com.TutorCentres.TutorSystem.core.vo.PageListVO;

import java.util.List;

public interface TutorUserService {
    String signUp(TutorRegisterDTO tutorUser);

    PageListVO queryTutorList(TutorSearchDTO tutorSearchDTO);

    TutorUser getTutorById(Integer tutorId);

    String editTutor(TutorRegisterDTO tutorRegisterDTO);

    String matchingStudentCase(Integer caseId);

    List<TutorMatchStudentCase> getMatchingCase(Integer tutorId);

    List<StudentMatchTutor> getStudentMatching();

    String cancelMatchingCase(Integer caseId);

    String rejectStudentMatching(Integer studentMatchId);

    String acceptStudentMatching(Integer studentMatchId);
}
