package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentCaseRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Student.service.StudentCaseService;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentUserDetail;
import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentCaseServiceImpl implements StudentCaseService {

    @Autowired
    private StudentCaseRepository studentCaseRepository;

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String createCase(StudentCaseDTO studentCaseDTO) {
        try {
            StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            StudentUser studentUser = studentRepository.findAllByEmail(studentUserDetail.getEmail());
            StudentCase studentCase = new StudentCase(studentCaseDTO);
            studentCase.setCreateDate(new Date());
            studentCase.setModifyDate(new Date());
            studentCase.setStudentUser(studentUser);
            studentCase.setClose(true);
            studentCaseRepository.save(studentCase);
            return null;
        }catch (Exception e){
            return "fail to save case";
        }
    }

    @Override
    public List<StudentCase> getStudentCaseList() {
        List<StudentCase> studentCaseList = studentCaseRepository.findAll();
        return studentCaseList;
    }
}
