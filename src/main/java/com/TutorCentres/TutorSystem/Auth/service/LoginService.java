package com.TutorCentres.TutorSystem.Auth.service;

import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;

public interface LoginService {
    JwtResponseDTO studentTutorLogin(UserLoginDTO userLoginDTO);
}
