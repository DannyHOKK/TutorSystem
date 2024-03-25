package com.TutorCentres.TutorSystem.core.config;

import com.TutorCentres.TutorSystem.Student.service.impl.StudentDetailsServiceImpl;
import com.TutorCentres.TutorSystem.Tutor.service.impl.TutorDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final TutorDetailsServiceImpl tutorUserService;

    @Autowired
    private final StudentDetailsServiceImpl studentUserService;

    public CustomUserDetailsService(TutorDetailsServiceImpl tutorUserService, StudentDetailsServiceImpl studentUserService) {
        this.tutorUserService = tutorUserService;
        this.studentUserService = studentUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails tutorUser = tutorUserService.loadUserByUsername(username);
        if (tutorUser != null) {
            return tutorUser;
        }

        UserDetails studentUser = studentUserService.loadUserByUsername(username);
        if (studentUser != null) {
            return studentUser;
        }

        throw new UsernameNotFoundException("找不到用戶");
    }
}
