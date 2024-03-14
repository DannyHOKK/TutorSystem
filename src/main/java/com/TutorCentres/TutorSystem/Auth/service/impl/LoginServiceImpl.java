package com.TutorCentres.TutorSystem.Auth.service.impl;

import com.TutorCentres.TutorSystem.Auth.service.LoginService;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Tutor.repository.TutorRepository;
import com.TutorCentres.TutorSystem.core.dto.JwtResponseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentUserDetail;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.dto.UserLoginDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import com.TutorCentres.TutorSystem.core.utils.JwtUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public JwtResponseDTO studentTutorLogin(UserLoginDTO userLoginDTO) {

        StudentUser checkStudentExist = studentRepository.findAllByEmail(userLoginDTO.getEmail());
        TutorUser checkTutorExit = tutorRepository.findAllByEmail(userLoginDTO.getEmail());
        if (!ObjectUtils.isEmpty(checkStudentExist) ){
            return studentLogin(userLoginDTO);
        } else if (!ObjectUtils.isEmpty(checkTutorExit)) {
            return tutorLogin(userLoginDTO);
        }

        return null;
    }

    @Override
    public String checkEmailExist(String email) {

        StudentUser checkStudentExist = studentRepository.findAllByEmail(email);
        TutorUser checkTutorExit = tutorRepository.findAllByEmail(email);

        if (!ObjectUtils.isEmpty(checkStudentExist) ){
            return "Email Exist";
        } else if (!ObjectUtils.isEmpty(checkTutorExit)) {
            return "Email Exist";
        }
        return null;
    }

    @Override
    public List<String> getAllEmail() {
        List<String> tutorEmailList = tutorRepository.findEmail();
        List<String> studentEmailList = studentRepository.findEmail();
        List<String> emailList = new ArrayList<>();
        emailList.addAll(tutorEmailList);
        emailList.addAll(studentEmailList);
        return emailList;
    }

    private JwtResponseDTO studentLogin(UserLoginDTO userLoginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtUtils.buildStudentJwt(authentication);
        StudentUserDetail studentUserDetail = (StudentUserDetail) authentication.getPrincipal();
        return new JwtResponseDTO(jwt,studentUserDetail.getId(), studentUserDetail.getEmail(), studentUserDetail.getAuthorities());
    }

    private JwtResponseDTO tutorLogin(UserLoginDTO userLoginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtUtils.buildJwt(authentication);
        TutorUserDetail tutorUserDetail = (TutorUserDetail) authentication.getPrincipal();
        return new JwtResponseDTO(jwt,tutorUserDetail.getId(), tutorUserDetail.getEmail(), tutorUserDetail.getAuthorities());

    }
}
