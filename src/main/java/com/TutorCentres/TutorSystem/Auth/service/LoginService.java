package com.TutorCentres.TutorSystem.Auth.service;

import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;

import java.util.List;

public interface LoginService {
    JwtResponseDTO studentTutorLogin(UserLoginDTO userLoginDTO);

    String checkEmailExist(String email);

    List<String> getAllEmail();
}
