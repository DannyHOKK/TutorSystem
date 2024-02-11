package com.TutorCentres.TutorSystem.Auth.service.impl;

import com.TutorCentres.TutorSystem.Auth.repository.TutorRepository;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TutorRepository tutorRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        TutorUser tutorUser = tutorRepository.findAllByEmail(email);

        if (tutorUser == null){
            return null;
        }

        return TutorUserDetail.build(tutorUser);
    }
}
