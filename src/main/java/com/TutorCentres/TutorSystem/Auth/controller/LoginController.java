package com.TutorCentres.TutorSystem.Auth.controller;

import com.TutorCentres.TutorSystem.Auth.service.LoginService;
import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;
import com.TutorCentres.TutorSystem.core.utils.JwtUtils;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LoginService loginService;


    @PostMapping(value = "/login")
    public ResultVO login(@RequestBody UserLoginDTO userLoginDTO){
        try{
            if (userLoginDTO.getEmail() == null || userLoginDTO.getPassword() == null){
                return ResultVoUtil.validFail("Please input credential");
            }
            JwtResponseDTO jwtResponseDTO = loginService.studentTutorLogin(userLoginDTO);
            if (ObjectUtils.isEmpty(jwtResponseDTO)){
                return ResultVoUtil.error("User not found");
            }
            return ResultVoUtil.success("login successfully", jwtResponseDTO);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
