package com.TutorCentres.TutorSystem.Auth.controller;

import com.TutorCentres.TutorSystem.Auth.service.TwilioService;
import com.TutorCentres.TutorSystem.core.dto.TwilioOtpDTO;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/twilio")
@CrossOrigin
public class TwilioOtpController {

    @Autowired
    private TwilioService twilioService;

    @GetMapping("/testing")
    public ResultVO testingTwilio(){
        try {
            twilioService.testingVertifySms();

            return ResultVoUtil.success();
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }

    @PostMapping("/auth/sendOtp")
    public ResultVO sendOtpByPhone(@RequestParam("phone") String phone){
        try {
            twilioService.sendOtpByPhone(phone);

            return ResultVoUtil.success("SMS OTP is sent");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
    @PostMapping("/auth/verifyPhone")
    public ResultVO verifyOtpPhone(@RequestBody TwilioOtpDTO twilioOtpDTO){
        try {
            String msg = twilioService.verifyOtpPhone(twilioOtpDTO);

            if(StringUtils.equals(msg, "approved")){
                return ResultVoUtil.success("approved");
            }

            return ResultVoUtil.error("verify failed");
        }catch (Exception e){
            return ResultVoUtil.error();
        }
    }
}
