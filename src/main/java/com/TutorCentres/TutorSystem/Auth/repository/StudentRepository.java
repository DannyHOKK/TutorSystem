package com.TutorCentres.TutorSystem.Auth.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentUser, Integer> {

    StudentUser findAllByEmail(String email);
}
