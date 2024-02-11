package com.TutorCentres.TutorSystem.Student.service;


import com.TutorCentres.TutorSystem.core.dto.StudentRegisterDTO;

public interface StudentUserService {
    String signUp(StudentRegisterDTO studentRegisterDTO);
}
