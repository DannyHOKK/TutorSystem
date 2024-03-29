package com.TutorCentres.TutorSystem.Student.service;

import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseSearchDTO;
import com.TutorCentres.TutorSystem.core.vo.PageListVO;
import com.TutorCentres.TutorSystem.core.vo.StudentCaseMatchingVO;

import java.util.List;

public interface StudentCaseService {
    String createCase(StudentCaseDTO studentCase);

    PageListVO getStudentCaseList(StudentCaseSearchDTO studentCaseSearchDTO);


    List<StudentCaseMatchingVO> getStudentCaseById();

    String rejectStudentCase(Integer tutorMatchCaseId);

    String acceptStudentCase(Integer tutorMatchCaseId);
}
