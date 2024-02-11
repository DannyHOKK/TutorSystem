package com.TutorCentres.TutorSystem.Auth.service;

import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;

public interface TutorUserService {
    String signUp(TutorRegisterDTO tutorUser);

}
