package com.TutorCentres.TutorSystem.Student.service;


import com.TutorCentres.TutorSystem.core.dto.ModifyStudentDetailsDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentMatchTutorDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentRegisterDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;

import java.util.List;

public interface StudentUserService {
    String signUp(StudentRegisterDTO studentRegisterDTO);

    String matchingTutor(StudentMatchTutorDTO tutorId);

    List<StudentMatchTutor> getStudentMatching();

    String cancelMatchingTutor(Integer caseId);

    StudentUser getStudentById();

    String modifyStudentDetails(ModifyStudentDetailsDTO modifyStudentDetailsDTO);
}
