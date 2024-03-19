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

    @Query(value = "SELECT s.case_id as caseId, s.create_date as createDate, s.modify_date as modifyDate, s.address as address, s.details_address as detailsAddress, " +
            " s.gender as gender, s.lesson_duration as lessonDuration, s.lesson_per_week as lessonPerWeek, s.max_salary as maxSalary, s.min_salary as minSalary, " +
            "s.student_level_type as studentLevelType, s.student_level as studentLevel, s.timeslot as timeslot, s.tutor_category as tutorCategory, s.tutor_content as tutorContent, " +
            "s.tutor_method as tutorMethod, s.tutor_remark as tutorRemark, s.tutor_request as tutorRequest, s.student_user_id as studentUserId, " +
            "s.tutor_gender as tutorRequestGender, s.status as status, " +
            "t.eng_name as engName, t.gender as tutorGender, t.current_job as currentJob, t.work_experience as workExperience, t.highest_tutor_level as highestTutorLevel, " +
            "t.note_provided as noteProvided, t.university as university, t.university_major as universityMajor, t.current_education_leve as currentEducationLevel, " +
            "t.id as tutorId, " +
            "tc.id as tutorMatchCaseId, tc.status as caseStatus, tc.create_date as caseCreateDate, tc.modify_date as caseModifyDate " +
            "FROM student_case s " +
            "LEFT JOIN tutor_match_student_case tc ON s.case_id = tc.student_case_id " +
            "LEFT JOIN tutor_user t ON t.id = tc.tutor_id " +
            "WHERE s.student_user_id = :studentUserId " +
            "ORDER BY FIELD(s.STATUS, 'waitAdmin', 'newTutor', 'new')", nativeQuery = true)
    List<StudentCaseMatchingVO> findAllJoinTableByStudentId(@Param("studentUserId") Integer studentUserId);
}
