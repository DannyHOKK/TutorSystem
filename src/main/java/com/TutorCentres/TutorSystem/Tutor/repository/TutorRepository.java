package com.TutorCentres.TutorSystem.Tutor.repository;

import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<TutorUser, Integer> {
    TutorUser findAllByEmail(String email);

    TutorUser findAllById(Integer tutorId);

    @Query(value = "select email from tutor_user", nativeQuery = true)
    List<String> findEmail();
}
