package com.TutorCentres.TutorSystem.Auth.controller;

import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;
import com.TutorCentres.TutorSystem.core.utils.JwtUtils;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
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


    @PostMapping(value = "/login")
    public ResultVO login(@RequestBody UserLoginDTO userLoginDTO){
        try{
            if (userLoginDTO.getEmail() == null || userLoginDTO.getPassword() == null){
                return ResultVoUtil.validFail("Please input credential");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = JwtUtils.buildJwt(authentication);
            TutorUserDetail tutorUserDetail = (TutorUserDetail) authentication.getPrincipal();
            JwtResponseDTO jwtResponseDTO = new JwtResponseDTO(jwt,tutorUserDetail.getId(), tutorUserDetail.getEmail(), tutorUserDetail.getAuthorities());

            return ResultVoUtil.success("login successfully", jwtResponseDTO);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
