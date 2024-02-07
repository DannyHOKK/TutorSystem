package com.TutorCentres.TutorSystem.Tutor.repository;

import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorUser, Integer> {
    TutorUser findAllByEmail(String email);
}
