package com.TutorCentres.TutorSystem.Auth.service.impl;

import com.TutorCentres.TutorSystem.Auth.service.TwilioService;
import com.TutorCentres.TutorSystem.core.config.TwilioConfig;
import com.TutorCentres.TutorSystem.core.dto.TwilioOtpDTO;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioServiceImpl implements TwilioService {

    @Autowired
    private TwilioConfig twilioConfig;

    @Override
    public void testingVertifySms() {
        Verification verification = Verification.creator(twilioConfig.getServiceSid(),"+85267308138","sms")
                .create();

        System.out.println(verification.getStatus());

        VerificationCheck verificationCheck = VerificationCheck.creator(twilioConfig.getServiceSid())
                .setTo("+85267308138")
                .setCode("123321")
                .create();

        System.out.println(verificationCheck.getStatus());


    }

    @Override
    public void sendOtpByPhone(String phone) {
        Verification verification = Verification.creator(twilioConfig.getServiceSid(),"+852" + phone,"sms")
                .create();

        System.out.println(verification.getStatus());
    }

    @Override
    public String verifyOtpPhone(TwilioOtpDTO twilioOtpDTO) {

            VerificationCheck verificationCheck = VerificationCheck.creator(twilioConfig.getServiceSid())
                    .setTo("+852" + twilioOtpDTO.getPhone())
                    .setCode(twilioOtpDTO.getOtpCode())
                    .create();

            System.out.println(verificationCheck.getStatus());

            return verificationCheck.getStatus();
    }
}
