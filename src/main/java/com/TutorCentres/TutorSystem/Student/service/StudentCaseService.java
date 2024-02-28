package com.TutorCentres.TutorSystem.Student.service;

import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentCase;

import java.util.List;

public interface StudentCaseService {
    String createCase(StudentCaseDTO studentCase);

    List<StudentCase> getStudentCaseList();
}
