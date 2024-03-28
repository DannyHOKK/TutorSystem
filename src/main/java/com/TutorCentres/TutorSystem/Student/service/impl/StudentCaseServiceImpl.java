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
import com.TutorCentres.TutorSystem.core.vo.PageListVO;
import com.TutorCentres.TutorSystem.core.vo.PaginationVO;
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
import java.util.ArrayList;
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
            studentCase.setStatus("new");
            studentCaseRepository.save(studentCase);
            return null;
        }catch (Exception e){
            return "fail to save case";
        }
    }

    @Override
    public PageListVO getStudentCaseList(StudentCaseSearchDTO studentCaseSearchDTO) {

        if (studentCaseSearchDTO.getCurrentPage() <= 0){
            studentCaseSearchDTO.setCurrentPage(1);
        }
        if(studentCaseSearchDTO.getPageSize() <= 0){
            studentCaseSearchDTO.setPageSize(10);
        }

        long startIndex = (studentCaseSearchDTO.getCurrentPage() - 1) * studentCaseSearchDTO.getPageSize() + 1;
        long endIndex = studentCaseSearchDTO.getPageSize() * studentCaseSearchDTO.getCurrentPage();


        String sqlscript = "select CASE_ID, TUTOR_GENDER, TUTOR_CATEGORY, TUTOR_CONTENT, TUTOR_METHOD, TUTOR_REMARK, GENDER," +
                "STUDENT_LEVEL, STUDENT_LEVEL_TYPE , MAX_SALARY, MIN_SALARY, ADDRESS, DETAILS_ADDRESS," +
                " LESSON_PER_WEEK, LESSON_DURATION, TIMESLOT, TUTOR_REQUEST from " +
                "( select ROW_NUMBER() OVER () AS SEQ_NO, s.* from student_case s)ss " +
                "where ss.SEQ_NO <= :endIndex and ss.SEQ_NO >= :startIndex ";
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
            sql.append(" and TUTOR_CONTENT LIKE :tutorContent");
            for (int i = 1; i < tutorContent.size(); i++) {
                sql.append(" or TUTOR_CONTENT LIKE :tutorContent").append(i);
            }
        }
        if(StringUtils.isNotEmpty(tutorGender)){
            sql.append(" and TUTOR_GENDER LIKE :tutorGender");
        }
        if(StringUtils.isNotEmpty(studentLevelType)){
            sql.append(" and STUDENT_LEVEL_TYPE LIKE :studentLevelType");
        }
        if (!CollectionUtils.isEmpty(studentLevel)) {
            sql.append(" and STUDENT_LEVEL LIKE :studentLevel");
            for (int i = 1; i < studentLevel.size(); i++) {
                sql.append(" or STUDENT_LEVEL LIKE :studentLevel").append(i);
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
            query.setParameter("tutorContent"  , "%" + tutorContent.get(0) + "%");
            for (int i = 1; i < tutorContent.size(); i++) {
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
            query.setParameter("studentLevel"  , "%" + studentLevel.get(0) + "%");
            for (int i = 1; i < studentLevel.size(); i++) {
                query.setParameter("studentLevel" + i , "%" + studentLevel.get(i) + "%");
            }
        }
        if(minSalary != null && minSalary > 0){
            query.setParameter("minSalary", minSalary);
        }
        if(maxSalary != null && maxSalary > 0){
            query.setParameter("maxSalary", maxSalary);
        }
        
        query.setParameter("startIndex",startIndex);
        query.setParameter("endIndex" , endIndex);

        List<StudentCaseMappingEntity> studentCaseMappingEntities = query.getResultList();
        List<StudentCaseMappingEntity> allStudentCase = getTotalStudentCaseList(studentCaseSearchDTO);

        PageListVO pageListVO = new PageListVO();
        if (!CollectionUtils.isEmpty(studentCaseMappingEntities)){
//            List<CityListMappingEntity> list = applist.stream().map(item ->{
//                CityListMappingEntity entity = new CityListMappingEntity();
//                entity.setCityCd(item.getCityCd());
//                entity.setCountryCd(item.getCountryCd());
//                entity.setEngCityDesc(item.getEngCityDesc());
//                return entity;
//            }).collect(Collectors.toList());

            pageListVO.setList(studentCaseMappingEntities);
            PaginationVO paginationVO = new PaginationVO();
            paginationVO.setTotal(allStudentCase.size());
            paginationVO.setPageSize(studentCaseSearchDTO.getPageSize());
            paginationVO.setCurrentPage(studentCaseSearchDTO.getCurrentPage());
            pageListVO.setPagination(paginationVO);
        }else {
            pageListVO.setList(new ArrayList());
            PaginationVO paginationVO = new PaginationVO();
            paginationVO.setTotal(0);
            paginationVO.setPageSize(studentCaseSearchDTO.getPageSize());
            paginationVO.setCurrentPage(1L);
        }


        return pageListVO;

    }

    public List<StudentCaseMappingEntity> getTotalStudentCaseList(StudentCaseSearchDTO studentCaseSearchDTO){


        String sqlscript = "select CASE_ID, TUTOR_GENDER, TUTOR_CATEGORY, TUTOR_CONTENT, TUTOR_METHOD, TUTOR_REMARK, GENDER," +
                "STUDENT_LEVEL, STUDENT_LEVEL_TYPE , MAX_SALARY, MIN_SALARY, ADDRESS, DETAILS_ADDRESS," +
                " LESSON_PER_WEEK, LESSON_DURATION, TIMESLOT, TUTOR_REQUEST from student_case " +
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
            sql.append(" and TUTOR_CONTENT LIKE :tutorContent");
            for (int i = 1; i < tutorContent.size(); i++) {
                sql.append(" or TUTOR_CONTENT LIKE :tutorContent").append(i);
            }
        }
        if(StringUtils.isNotEmpty(tutorGender)){
            sql.append(" and TUTOR_GENDER LIKE :tutorGender");
        }
        if(StringUtils.isNotEmpty(studentLevelType)){
            sql.append(" and STUDENT_LEVEL_TYPE LIKE :studentLevelType");
        }
        if (!CollectionUtils.isEmpty(studentLevel)) {
            sql.append(" and STUDENT_LEVEL LIKE :studentLevel");
            for (int i = 1; i < studentLevel.size(); i++) {
                sql.append(" or STUDENT_LEVEL LIKE :studentLevel").append(i);
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
            query.setParameter("tutorContent"  , "%" + tutorContent.get(0) + "%");
            for (int i = 1; i < tutorContent.size(); i++) {
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
            query.setParameter("studentLevel"  , "%" + studentLevel.get(0) + "%");
            for (int i = 1; i < studentLevel.size(); i++) {
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

    @Override
    public String rejectStudentCase(Integer tutorMatchCaseId) {
        try {
            TutorMatchStudentCase tutorMatchStudentCase = tutorMatchStudentCaseRepository.findById(tutorMatchCaseId).orElseThrow(null);
            StudentCase studentCase = studentCaseRepository.findById(tutorMatchStudentCase.getStudentCase().getCaseId()).orElseThrow(null);
            tutorMatchStudentCase.setStatus("rejected");
            tutorMatchStudentCase.setModifyDate(new Date());
            tutorMatchStudentCaseRepository.save(tutorMatchStudentCase);
            studentCase.setStatus("new");
            studentCaseRepository.save(studentCase);
            return null;
        }catch (Exception e){
            return "無法拒絕導師";
        }

    }

    @Override
    public String acceptStudentCase(Integer tutorMatchCaseId) {
        try {
            TutorMatchStudentCase tutorMatchStudentCase = tutorMatchStudentCaseRepository.findById(tutorMatchCaseId).orElseThrow(null);
            StudentCase studentCase = studentCaseRepository.findById(tutorMatchStudentCase.getStudentCase().getCaseId()).orElseThrow(null);
            tutorMatchStudentCase.setStatus("success");
            tutorMatchStudentCase.setModifyDate(new Date());
            studentCase.setStatus("waitAdmin");
            tutorMatchStudentCaseRepository.save(tutorMatchStudentCase);
            studentCaseRepository.save(studentCase);
            return null;
        }catch (Exception e){
            return "無法拒絕導師";
        }

    }

}
