package com.TutorCentres.TutorSystem.Tutor.controller;

import com.TutorCentres.TutorSystem.Tutor.service.TutorUserService;
import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;
import com.TutorCentres.TutorSystem.core.utils.JwtUtils;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin
public class TutorAuthController {

    @Autowired
    private TutorUserService tutorUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/signup")
    public ResultVO signUp(@RequestBody TutorRegisterDTO tutorRegisterDTO){
        try{
            String errMsg = tutorUserService.signUp(tutorRegisterDTO);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("successfully register");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @GetMapping("/testing")
    public ResultVO testing(){
        return ResultVoUtil.success("testing");
    }
}
