package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.core.dto.StudentUserDetail;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        StudentUser studentUser = studentRepository.findAllByEmail(email);
        if (studentUser == null){
            return null;
        }
        return StudentUserDetail.build(studentUser);
    }
}
