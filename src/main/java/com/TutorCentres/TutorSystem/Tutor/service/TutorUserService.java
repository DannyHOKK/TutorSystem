package com.TutorCentres.TutorSystem.Tutor.service;

import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorUserLoginDTO;

public interface TutorUserService {
    String signUp(TutorRegisterDTO tutorUser);

}
