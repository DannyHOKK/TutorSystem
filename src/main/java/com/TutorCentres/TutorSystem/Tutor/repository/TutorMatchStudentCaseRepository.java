package com.TutorCentres.TutorSystem.Tutor.repository;

import com.TutorCentres.TutorSystem.core.entity.TutorMatchStudentCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorMatchStudentCaseRepository extends JpaRepository<TutorMatchStudentCase, Integer> {
    List<TutorMatchStudentCase> findAllById(Integer tutorId);
    @Query(value = "select * from tutor_match_student_case where TUTOR_ID = :tutorId " +
            " ORDER BY FIELD(STATUS, 'success', 'pending', 'rejected', 'cancel')",nativeQuery = true)
    List<TutorMatchStudentCase> findAllByTutorId(@Param("tutorId") Integer tutorId);

    @Query(value = "select * from tutor_match_student_case where STUDENT_CASE_ID = :caseId and TUTOR_ID = :tutorId",nativeQuery = true)
    TutorMatchStudentCase findByCaseId(@Param("caseId") Integer caseId, @Param("tutorId") Integer tutorId);

    @Query(value = "SELECT tc.* FROM tutor_match_student_case tc " +
            "inner join student_case s  " +
            "on s.case_id = tc.student_case_id " +
            "where s.STUDENT_USER_ID = :studentUserId", nativeQuery = true)
    List<TutorMatchStudentCase> findAllByStudentId(@Param("studentUserId") Integer studentUserId);

    @Query(value = "select * from tutor_match_student_case where STUDENT_CASE_ID = :caseId",nativeQuery = true)
    List<TutorMatchStudentCase> findAllByCaseId(Integer caseId);
}
