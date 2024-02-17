package com.TutorCentres.TutorSystem.Student.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentUser, Integer> {

    StudentUser findAllByEmail(String email);

    @Query(value = "select email from student_user", nativeQuery = true)
    List<String> findEmail();
}
