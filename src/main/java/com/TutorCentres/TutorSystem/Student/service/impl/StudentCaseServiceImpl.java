package com.TutorCentres.TutorSystem.Student.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentCaseRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Student.service.StudentCaseService;
import com.TutorCentres.TutorSystem.Tutor.repository.TutorMatchStudentCaseRepository;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseSearchDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentUserDetail;
import com.TutorCentres.TutorSystem.core.entity.StudentCase;
import com.TutorCentres.TutorSystem.core.entity.StudentCaseMappingEntity;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
import com.TutorCentres.TutorSystem.core.entity.TutorMatchStudentCase;
import com.TutorCentres.TutorSystem.core.vo.StudentCaseMatchingVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class StudentCaseServiceImpl implements StudentCaseService {

    @Autowired
    private StudentCaseRepository studentCaseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TutorMatchStudentCaseRepository tutorMatchStudentCaseRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public String createCase(StudentCaseDTO studentCaseDTO) {
        try {
            StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            StudentUser studentUser = studentRepository.findAllByEmail(studentUserDetail.getEmail());
            StudentCase studentCase = new StudentCase(studentCaseDTO);
            studentCase.setCreateDate(new Date());
            studentCase.setModifyDate(new Date());
            studentCase.setStudentUser(studentUser);
            studentCase.setStatus("pending");
            studentCaseRepository.save(studentCase);
            return null;
        }catch (Exception e){
            return "fail to save case";
        }
    }

    @Override
    public List<StudentCaseMappingEntity> getStudentCaseList(StudentCaseSearchDTO studentCaseSearchDTO) {

        String sqlscript = "select CASE_ID, TUTOR_GENDER, TUTOR_CATEGORY, TUTOR_CONTENT, TUTOR_METHOD, TUTOR_REMARK, GENDER," +
                "STUDENT_LEVEL, STUDENT_LEVEL_TYPE , MAX_SALARY, MIN_SALARY, ADDRESS, DETAILS_ADDRESS," +
                " LESSON_PER_WEEK, LESSON_DURATION, TIMESLOT, TUTOR_REQUEST, CLOSE from student_case " +
                "where 1 = 1 ";
        StringBuilder sql = new StringBuilder(sqlscript);

        String tutorCategory = null;
        List<String> tutorContent = null;
        String tutorGender = null;
        String studentLevelType = null;
        List<String> studentLevel = null;
        Integer minSalary = null;
        Integer maxSalary = null;


        if (ObjectUtils.isNotEmpty(studentCaseSearchDTO)) {
            tutorCategory = studentCaseSearchDTO.getTutorCategory();
            tutorContent = studentCaseSearchDTO.getTutorContent();
            tutorGender = studentCaseSearchDTO.getTutorGender();
            studentLevelType = studentCaseSearchDTO.getStudentLevelType();
            studentLevel = studentCaseSearchDTO.getStudentLevel();
            minSalary = studentCaseSearchDTO.getLowestSalary();
            maxSalary = studentCaseSearchDTO.getMaxSalary();
        }

        if(StringUtils.isNotEmpty(tutorCategory)){
            sql.append(" and TUTOR_CATEGORY LIKE :tutorCategory");
        }
        if (!CollectionUtils.isEmpty(tutorContent)) {
            for (int i = 0; i < tutorContent.size(); i++) {
                sql.append(" and TUTOR_CONTENT LIKE :tutorContent").append(i);
            }
        }
        if(StringUtils.isNotEmpty(tutorGender)){
            sql.append(" and TUTOR_GENDER LIKE :tutorGender");
        }
        if(StringUtils.isNotEmpty(studentLevelType)){
            sql.append(" and STUDENT_LEVEL_TYPE LIKE :studentLevelType");
        }
        if (!CollectionUtils.isEmpty(studentLevel)) {
            for (int i = 0; i < studentLevel.size(); i++) {
                sql.append(" and STUDENT_LEVEL LIKE :studentLevel").append(i);
            }
        }
        if (minSalary != null && minSalary > 0) {
            sql.append(" and MIN_SALARY >= :minSalary");
        }
        if (maxSalary != null && maxSalary > 0) {
            sql.append(" and MAX_SALARY <= :maxSalary");
        }

        Query query = entityManager.createNativeQuery(sql.toString(), "StudentCaseMappingEntity");


        if(StringUtils.isNotEmpty(tutorCategory)){
            query.setParameter("tutorCategory", tutorCategory);
        }
        if (!CollectionUtils.isEmpty(tutorContent)) {
            for (int i = 0; i < tutorContent.size(); i++) {
                query.setParameter("tutorContent" + i , "%" + tutorContent.get(i) + "%");
            }
        }
        if(StringUtils.isNotEmpty(tutorGender)){
            query.setParameter("tutorGender", tutorGender);
        }
        if(StringUtils.isNotEmpty(studentLevelType)){
            query.setParameter("studentLevelType", studentLevelType);
        }
        if (!CollectionUtils.isEmpty(studentLevel)) {
            for (int i = 0; i < studentLevel.size(); i++) {
                query.setParameter("studentLevel" + i , "%" + studentLevel.get(i) + "%");
            }
        }
        if(minSalary != null && minSalary > 0){
            query.setParameter("minSalary", minSalary);
        }
        if(maxSalary != null && maxSalary > 0){
            query.setParameter("maxSalary", maxSalary);
        }

        List<StudentCaseMappingEntity> studentCaseMappingEntities = query.getResultList();
        return studentCaseMappingEntities;

    }

    @Override
    public List<StudentCaseMatchingVO> getStudentCaseById() {
        StudentUserDetail studentUserDetail = (StudentUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<StudentCase> studentCaseList = studentCaseRepository.findAllByStudentId(studentUserDetail.getId());
        List<TutorMatchStudentCase> tutorMatchStudentCaseList = tutorMatchStudentCaseRepository.findAllByStudentId(studentUserDetail.getId());

        List<StudentCaseMatchingVO> studentCaseMatchingVOS = studentCaseRepository.findAllJoinTableByStudentId(studentUserDetail.getId());
        return studentCaseMatchingVOS;
    }


}
