package com.TutorCentres.TutorSystem.Auth.service;


import com.TutorCentres.TutorSystem.core.dto.StudentRegisterDTO;

public interface StudentUserService {
    String signUp(StudentRegisterDTO studentRegisterDTO);
}
