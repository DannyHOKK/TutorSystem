package com.TutorCentres.TutorSystem.Student.repository;

import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import com.TutorCentres.TutorSystem.core.vo.StudentCaseMatchingVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCaseRepository extends JpaRepository<StudentCase, Integer> {

    @Query(value = "select * from student_case where STUDENT_USER_ID = :studentUserId",nativeQuery = true)
    List<StudentCase> findAllByStudentId(@Param("studentUserId") Integer studentUserId);

    @Query(value = "SELECT s.CASE_ID as caseId, s.address as address, s.create_date as createDate, s.details_address as detailsAddress, " +
            "tc.tutor_id as tutorId " +
            "FROM student_case s " +
            "LEFT JOIN tutor_match_student_case tc ON s.case_id = tc.student_case_id " +
            "LEFT JOIN tutor_user t ON t.id = tc.tutor_id " +
            "WHERE s.student_user_id = :studentUserId", nativeQuery = true)
    List<StudentCaseMatchingVO> findAllJoinTableByStudentId(@Param("studentUserId") Integer studentUserId);
}
