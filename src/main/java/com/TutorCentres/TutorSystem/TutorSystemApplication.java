package com.TutorCentres.TutorSystem;

import com.TutorCentres.TutorSystem.core.config.TwilioConfig;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class TutorSystemApplication {

	@Autowired
	private TwilioConfig twilioConfig;

	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());

	}

	public static void main(String[] args) {
		SpringApplication.run(TutorSystemApplication.class, args);
	}

}
