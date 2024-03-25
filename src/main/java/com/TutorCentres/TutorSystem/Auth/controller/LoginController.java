package com.TutorCentres.TutorSystem.Auth.controller;

import com.TutorCentres.TutorSystem.Auth.service.LoginService;
import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;
import com.TutorCentres.TutorSystem.core.utils.JwtUtils;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                return ResultVoUtil.error("登入名稱/密碼錯誤");
            }
            return ResultVoUtil.success("登入成功", jwtResponseDTO);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PostMapping("/checkEmailExist")
    public ResultVO checkEmailExist(@RequestParam("email") String email){
        try{
            String errMsg = loginService.checkEmailExist(email);
            if(StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("Email available");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @GetMapping("/getAllEmail")
    public ResultVO getAllEmail(){
        try{
            List<String> emailList = loginService.getAllEmail();
            return ResultVoUtil.success(emailList);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
