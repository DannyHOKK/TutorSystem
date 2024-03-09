package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentMapTutorRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Student.service.StudentUserService;
import com.TutorCentres.TutorSystem.Tutor.repository.TutorRepository;
import com.TutorCentres.TutorSystem.core.dto.StudentRegisterDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentUserDetail;
import com.TutorCentres.TutorSystem.core.entity.StudentMapTutor;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentUserServiceImpl implements StudentUserService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private StudentMapTutorRepository studentMapTutorRepository;
    @Override
    public String signUp(StudentRegisterDTO studentRegisterDTO) {

        StudentUser checkStudentExist = studentRepository.findAllByEmail(studentRegisterDTO.getEmail());
        TutorUser checkTutorExit = tutorRepository.findAllByEmail(studentRegisterDTO.getEmail());
        if (!ObjectUtils.isEmpty(checkStudentExist) || !ObjectUtils.isEmpty(checkTutorExit)  ){
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

    @Override
    public String matchingTutor(Integer tutorId) {
        try {
            TutorUser tutorUser = tutorRepository.findAllById(tutorId);
            StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            StudentUser studentUser = studentRepository.findAllByEmail(studentUserDetail.getEmail());
            StudentMapTutor studentMapTutor = new StudentMapTutor(studentUser,tutorUser,new Date(), new Date(),"pending");
            studentMapTutorRepository.save(studentMapTutor);
            return null;
        }catch (Exception e){
            return "Cant Save";
        }
    }
}
