package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Student.service.StudentUserService;
import com.TutorCentres.TutorSystem.core.dto.StudentRegisterDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentUserServiceImpl implements StudentUserService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public String signUp(StudentRegisterDTO studentRegisterDTO) {

        StudentUser checkUserExist = studentRepository.findAllByEmail(studentRegisterDTO.getEmail());
        if (!ObjectUtils.isEmpty(checkUserExist)){
            return "User exited";
        }
        StudentUser studentUser = new StudentUser(studentRegisterDTO);

        //Change Array to String
        studentUser.setPassword(passwordEncoder.encode(studentRegisterDTO.getPassword()));
        studentUser.setCreateDate(new Date());
        studentUser.setModifyDate(new Date());
        studentUser.setRoles("ROLE_STUDENT");

        studentRepository.save(studentUser);

        return null;
    }
}
