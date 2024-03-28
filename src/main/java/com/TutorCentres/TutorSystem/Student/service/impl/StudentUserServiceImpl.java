package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentMatchTutorRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Student.service.StudentUserService;
import com.TutorCentres.TutorSystem.Tutor.repository.TutorRepository;
import com.TutorCentres.TutorSystem.core.dto.*;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentUserServiceImpl implements StudentUserService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private StudentMatchTutorRepository studentMatchTutorRepository;
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
    public String matchingTutor(StudentMatchTutorDTO studentMatchTutorDTO) {
        try {
            TutorUser tutorUser = tutorRepository.findAllById(studentMatchTutorDTO.getTutorId());
            StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            StudentUser studentUser = studentRepository.findAllByEmail(studentUserDetail.getEmail());
            StudentMatchTutor checkStudentMatchTutor = studentMatchTutorRepository
                    .findByTutorIdAndStudentId(studentUserDetail.getId(), studentMatchTutorDTO.getTutorId());

            if (ObjectUtils.isNotEmpty(checkStudentMatchTutor)){
                if(StringUtils.contains(checkStudentMatchTutor.getStatus(), "cancel") ){
//                    return "Matching Student Case already exist";
                    studentMatchTutorRepository.deleteById(checkStudentMatchTutor.getId());
                }else if(StringUtils.contains(checkStudentMatchTutor.getStatus(), "rejected") ){
                    return "導師已拒絕過你";
                }else if(StringUtils.contains(checkStudentMatchTutor.getStatus(), "success") ){
                    return "你的個案已配對成功";
                }else{
                    return "你的個案正在處理";
                }
            }

            StudentMatchTutor studentMatchTutor = new StudentMatchTutor(studentUser,tutorUser
                    ,studentMatchTutorDTO.getStudentLevelType(),studentMatchTutorDTO.getStudentLevel()
                    ,studentMatchTutorDTO.getSalary(),studentMatchTutorDTO.getTutorContent()
                    ,studentMatchTutorDTO.getTutorMethod(),studentMatchTutorDTO.getAddress()
                    ,new Date(), new Date(),"pending");

            studentMatchTutorRepository.save(studentMatchTutor);
            return null;
        }catch (Exception e){
            return "Cant Save";
        }
    }

    @Override
    public List<StudentMatchTutor> getStudentMatching() {
        StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<StudentMatchTutor> studentMatchTutor = studentMatchTutorRepository.findAllByStudentId(studentUserDetail.getId());
        return studentMatchTutor;
    }

    @Override
    public String cancelMatchingTutor(Integer caseId) {
        try{
            StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            StudentMatchTutor studentMatchTutor = studentMatchTutorRepository.findById(caseId).orElseThrow(null);

            studentMatchTutor.setStatus("cancel");
            studentMatchTutor.setModifyDate(new Date());
            studentMatchTutorRepository.save(studentMatchTutor);
            return null;
        }catch (Exception e){
            return "cancel Student Matching Tutor Case failed";
        }
    }

    @Override
    public StudentUser getStudentById() {
        StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        StudentUser studentUser = studentRepository.findById(studentUserDetail.getId()).orElseThrow(null);
        return studentUser;
    }

    @Override
    public String modifyStudentDetails(ModifyStudentDetailsDTO modifyStudentDetailsDTO) {

        try {
            StudentUser studentUser = studentRepository.findAllByEmail(modifyStudentDetailsDTO.getEmail());

            studentUser.setEngName(modifyStudentDetailsDTO.getEngName());
            studentUser.setChineseName(modifyStudentDetailsDTO.getChineseName());
            studentUser.setAddress(modifyStudentDetailsDTO.getAddress());
            studentUser.setGender(modifyStudentDetailsDTO.getGender());

            studentRepository.save(studentUser);
            return null;
        }catch (Exception e){
            return "更改學生資料失敗";
        }

    }

}