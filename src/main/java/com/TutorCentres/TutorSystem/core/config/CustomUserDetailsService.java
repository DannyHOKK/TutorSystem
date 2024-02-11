package com.TutorCentres.TutorSystem.core.config;

import com.TutorCentres.TutorSystem.Auth.service.impl.StudentDetailsServiceImpl;
import com.TutorCentres.TutorSystem.Auth.service.impl.TutorDetailsServiceImpl;
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

        // Implement your logic to fetch user details based on the user type or data source
        UserDetails tutorUser = tutorUserService.loadUserByUsername(username);
        if (tutorUser == null) {
            // If the user is not found in the tutor user service, try fetching from the student user service
            UserDetails studentUser = studentUserService.loadUserByUsername(username);
            if (studentUser == null) {
                throw new UsernameNotFoundException("User not found");
            } else {
                return studentUser;
            }
        } else {
            return tutorUser;
        }
    }
}
