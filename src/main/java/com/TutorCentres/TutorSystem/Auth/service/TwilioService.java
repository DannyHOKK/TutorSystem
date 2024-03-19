package com.TutorCentres.TutorSystem.Auth.service;

import com.TutorCentres.TutorSystem.core.dto.TwilioOtpDTO;

public interface TwilioService {
    void testingVertifySms();

    void sendOtpByPhone(String phone);

    String verifyOtpPhone(TwilioOtpDTO twilioOtpDTO);
}
