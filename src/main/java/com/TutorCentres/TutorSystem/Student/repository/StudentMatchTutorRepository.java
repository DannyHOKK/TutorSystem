package com.TutorCentres.TutorSystem.Student.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMatchTutorRepository extends JpaRepository<StudentMatchTutor, Integer> {
    @Query(value = "SELECT * FROM student_match_tutor WHERE TUTOR_ID = :tutorId " +
            " ORDER BY FIELD(STATUS, 'success', 'pending', 'rejected', 'cancel')", nativeQuery = true)
    List<StudentMatchTutor> findAllByTutorId(@Param("tutorId") Integer tutorId);

    @Query(value = "SELECT * FROM student_match_tutor WHERE STUDENT_USER_ID = :studentId " +
            " ORDER BY FIELD(STATUS, 'success', 'pending', 'rejected', 'cancel')", nativeQuery = true)
    List<StudentMatchTutor> findAllByStudentId(@Param("studentId") Integer studentId);

    @Query(value = "SELECT * FROM student_match_tutor WHERE TUTOR_ID = :tutorId and STUDENT_USER_ID = :studentId" , nativeQuery = true)
    StudentMatchTutor findByTutorIdAndStudentId( @Param("studentId") Integer studentId,@Param("tutorId") Integer tutorId);
}
