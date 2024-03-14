package com.TutorCentres.TutorSystem.Student.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCaseRepository extends JpaRepository<StudentCase, Integer> {

    @Query(value = "select * from student_case where STUDENT_USER_ID = :studentUserId",nativeQuery = true)
    List<StudentCase> findAllByStudentId(@Param("studentUserId") Integer studentUserId);
}
