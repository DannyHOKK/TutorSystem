package com.TutorCentres.TutorSystem.Student.service;

import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentCaseMappingEntity;

import java.util.List;

public interface StudentCaseService {
    String createCase(StudentCaseDTO studentCase);

    List<StudentCaseMappingEntity> getStudentCaseList(StudentCaseSearchDTO studentCaseSearchDTO);
}
