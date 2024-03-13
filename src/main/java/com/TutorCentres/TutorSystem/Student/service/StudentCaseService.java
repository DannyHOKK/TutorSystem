package com.TutorCentres.TutorSystem.Student.service;

import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import com.TutorCentres.TutorSystem.core.entity.StudentCaseMappingEntity;
import com.TutorCentres.TutorSystem.core.entity.TutorMatchStudentCase;

import java.util.List;

public interface StudentCaseService {
    String createCase(StudentCaseDTO studentCase);

    List<StudentCaseMappingEntity> getStudentCaseList(StudentCaseSearchDTO studentCaseSearchDTO);


    List<StudentCase> getStudentCaseById();

}
