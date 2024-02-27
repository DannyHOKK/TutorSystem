package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentCaseRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Student.service.StudentCaseService;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentCaseServiceImpl implements StudentCaseService {

    @Autowired
    private StudentCaseRepository studentCaseRepository;

    @Override
    public String createCase(StudentCaseDTO studentCaseDTO) {
        try {
            StudentCase studentCase = new StudentCase(studentCaseDTO);
            studentCase.setCreateDate(new Date());
            studentCase.setModifyDate(new Date());
            studentCase.setClose(true);
            studentCaseRepository.save(studentCase);
            return null;
        }catch (Exception e){
            return "fail to save case";
        }
    }
}
