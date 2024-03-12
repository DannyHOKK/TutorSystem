package com.TutorCentres.TutorSystem.Tutor.service.impl;

import com.TutorCentres.TutorSystem.Student.repository.StudentCaseRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentMatchTutorRepository;
import com.TutorCentres.TutorSystem.Student.repository.StudentRepository;
import com.TutorCentres.TutorSystem.Tutor.repository.TutorMatchStudentCaseRepository;
import com.TutorCentres.TutorSystem.Tutor.repository.TutorRepository;
import com.TutorCentres.TutorSystem.Tutor.service.TutorUserService;
import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorSearchDTO;
import com.TutorCentres.TutorSystem.core.dto.TutorUserDetail;
import com.TutorCentres.TutorSystem.core.entity.*;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Service
public class TutorUserServiceImpl implements TutorUserService {

    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCaseRepository studentCaseRepository;
    @Autowired
    private TutorMatchStudentCaseRepository tutorMatchStudentCaseRepository;
    @Autowired
    private StudentMatchTutorRepository studentMatchTutorRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String signUp(TutorRegisterDTO tutorRegisterDTO) {

        StudentUser checkStudentExist = studentRepository.findAllByEmail(tutorRegisterDTO.getEmail());
        TutorUser checkTutorExit = tutorRepository.findAllByEmail(tutorRegisterDTO.getEmail());
        if (!ObjectUtils.isEmpty(checkStudentExist) || !ObjectUtils.isEmpty(checkTutorExit)  ){
            return "User exited";
        }
        TutorUser tutorUser = new TutorUser(tutorRegisterDTO);

        //Change Array to String
        String areaList = String.join(",",tutorRegisterDTO.getTutorAreas());
        if (!CollectionUtils.isEmpty(tutorRegisterDTO.getTutorContent())){
            String tutorContent = String.join(",", tutorRegisterDTO.getTutorContent());
            tutorUser.setTutorContent(tutorContent);
        }
        if (!CollectionUtils.isEmpty(tutorRegisterDTO.getTutorLevel())){
            String tutorLevel = String.join(",", tutorRegisterDTO.getTutorLevel());
            tutorUser.setTutorLevel(tutorLevel);
        }
        if (!CollectionUtils.isEmpty(tutorRegisterDTO.getTutorSpeaking())){
            String tutorSpeaking = String.join(",", tutorRegisterDTO.getTutorSpeaking());
            tutorUser.setTutorSpeaking(tutorSpeaking);
        }
        if (!CollectionUtils.isEmpty(tutorRegisterDTO.getTutorMusic())){
            String tutorMusic = String.join(",", tutorRegisterDTO.getTutorMusic());
            tutorUser.setTutorMusic(tutorMusic);
        }
        if (!CollectionUtils.isEmpty(tutorRegisterDTO.getTutorOtherLevel())){
            String tutorOtherLevel = String.join(",", tutorRegisterDTO.getTutorOtherLevel());
            tutorUser.setTutorOtherLevel(tutorOtherLevel);
        }

        tutorUser.setPassword(passwordEncoder.encode(tutorRegisterDTO.getPassword()));
        tutorUser.setTutorAreas(areaList);
        tutorUser.setExamResult(tutorRegisterDTO.getExamResult());
        tutorUser.setCreateDate(new Date());
        tutorUser.setModifyDate(new Date());
        tutorUser.setRoles("ROLE_TUTOR");

        tutorRepository.save(tutorUser);

        return null;
    }

    @Override
    public List<TutorListMappingEntity> queryTutorList( TutorSearchDTO tutorSearchDTO) {

        String sqlscript = "select ID, ENG_NAME, GENDER, TUTOR_CONTENT, TUTOR_LEVEL, TUTOR_AREAS, LOWEST_SALARY, UNIVERSITY, HIGHEST_EDUCATION, HIGHEST_TUTOR_LEVEL, UNIVERSITY_MAJOR, INTRO_TITLE, INTRO" +
                " from tutor_user ";
        StringBuilder sql = new StringBuilder(sqlscript);

        List<String> tutorContent = null;
        List<String> tutorAreas = null;
        List<String> tutorLevel = null;
        Integer lowestSalary = null;
        Integer maxSalary = null;

        if (ObjectUtils.isNotEmpty(tutorSearchDTO)) {
            tutorContent = tutorSearchDTO.getTutorContent();
            tutorAreas = tutorSearchDTO.getTutorAreas();
            tutorLevel = tutorSearchDTO.getTutorLevel();
            lowestSalary = tutorSearchDTO.getLowestSalary();
            maxSalary = tutorSearchDTO.getMaxSalary();
        }
        sql.append(" WHERE 1=1 ");
        if (!CollectionUtils.isEmpty(tutorContent)) {
            for (int i = 0; i < tutorContent.size(); i++) {
                sql.append(" and TUTOR_CONTENT LIKE :tutorContent").append(i);
            }
        }
        if (!CollectionUtils.isEmpty(tutorAreas)) {
            for (int i = 0; i < tutorAreas.size(); i++) {
                sql.append(" and TUTOR_AREAS LIKE :tutorAreas").append(i);
            }
        }
        if (!CollectionUtils.isEmpty(tutorLevel)) {
            for (int i = 0; i < tutorLevel.size(); i++) {
                sql.append(" and TUTOR_LEVEL LIKE :tutorLevel").append(i);
            }
        }
        if (lowestSalary != null && lowestSalary > 0) {
            sql.append(" and LOWEST_SALARY >= :lowestSalary");
        }
        if (maxSalary != null && maxSalary > 0) {
            sql.append(" and LOWEST_SALARY <= :maxSalary");
        }

        Query query = entityManager.createNativeQuery(sql.toString(), "TutorListMappingEntity");

        if (!CollectionUtils.isEmpty(tutorContent)) {
            for (int i = 0; i < tutorContent.size(); i++) {
                query.setParameter("tutorContent" + i , "%" + tutorContent.get(i) + "%");
            }
        }
        if (!CollectionUtils.isEmpty(tutorAreas)) {
            for (int i = 0; i < tutorAreas.size(); i++) {
                query.setParameter("tutorAreas" + i , "%" + tutorAreas.get(i) + "%");
            }
        }
        if (!CollectionUtils.isEmpty(tutorLevel)) {
            for (int i = 0; i < tutorLevel.size(); i++) {
                query.setParameter("tutorLevel" + i, "%" + tutorLevel.get(i) + "%");
            }
        }

        if(lowestSalary != null && lowestSalary > 0){
            query.setParameter("lowestSalary", lowestSalary);
        }
        if(maxSalary != null && maxSalary > 0){
            query.setParameter("maxSalary", maxSalary);
        }


        List<TutorListMappingEntity> tutorListMappingEntities = query.getResultList();
        return tutorListMappingEntities;

    }

    @Override
    public TutorUser getTutorById(Integer tutorId) {

        TutorUser tutorUser = tutorRepository.findAllById(tutorId);

        if (ObjectUtils.isEmpty(tutorUser)){
            return null;
        }
        return tutorUser;
    }

    @Override
    public String editTutor(TutorRegisterDTO tutorRegisterDTO) {
        return null;
    }

    @Override
    public String matchingStudentCase(Integer caseId) {
        try{
            StudentCase studentCase = studentCaseRepository.findById(caseId).orElseThrow(null);
            TutorUserDetail tutorUserDetail = (TutorUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            TutorUser tutorUser = tutorRepository.findById(tutorUserDetail.getId()).orElseThrow(null);
            TutorMatchStudentCase checkTutorMatchStudentCase = tutorMatchStudentCaseRepository.findByCaseId(caseId,tutorUser.getId());

            if(ObjectUtils.isNotEmpty(checkTutorMatchStudentCase) ){
                if(StringUtils.contains(checkTutorMatchStudentCase.getStatus(), "cancel") ){
//                    return "Matching Student Case already exist";
                    tutorMatchStudentCaseRepository.deleteById(checkTutorMatchStudentCase.getId());
                }else if(StringUtils.contains(checkTutorMatchStudentCase.getStatus(), "rejected") ){
                    return "學生個案已拒絕過你";
                }else if(StringUtils.contains(checkTutorMatchStudentCase.getStatus(), "success") ){
                    return "學生個案已配對成功";
                }else{
                    return "學生個案正在處理";
                }
            }

            TutorMatchStudentCase tutorMatchStudentCase = new TutorMatchStudentCase();
            tutorMatchStudentCase.setStudentCase(studentCase);
            tutorMatchStudentCase.setTutorUser(tutorUser);
            tutorMatchStudentCase.setCreateDate(new Date());
            tutorMatchStudentCase.setModifyDate(new Date());
            tutorMatchStudentCase.setStatus("pending");
            tutorMatchStudentCaseRepository.save(tutorMatchStudentCase);
            return null;
        }catch (Exception e){
            return "matchingStudentCase mapping failed";
        }
    }

    @Override
    public List<TutorMatchStudentCase> getMatchingCase(Integer tutorId) {

        List<TutorMatchStudentCase> tutorMatchStudentCases = tutorMatchStudentCaseRepository.findAllByTutorId(tutorId);
        return tutorMatchStudentCases;
    }

    @Override
    public List<StudentMatchTutor> getStudentMatching() {
        TutorUserDetail tutorUserDetail = (TutorUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<StudentMatchTutor> studentMatchTutor = studentMatchTutorRepository.findAllByTutorId(tutorUserDetail.getId());
        return studentMatchTutor;
    }

    @Override
    public String cancelMatchingCase(Integer caseId) {
        try{
            TutorUserDetail tutorUserDetail = (TutorUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            TutorMatchStudentCase tutorMatchStudentCase = tutorMatchStudentCaseRepository.findByCaseId(caseId, tutorUserDetail.getId());
//            TutorMatchStudentCase newTutorMatchStudentCase = new TutorMatchStudentCase(tutorMatchStudentCase.getStudentCase(),tutorMatchStudentCase.getTutorUser(),tutorMatchStudentCase.getCreateDate(),tutorMatchStudentCase.getModifyDate(),"cancel");

            tutorMatchStudentCase.setStatus("cancel");
            tutorMatchStudentCase.setModifyDate(new Date());
            tutorMatchStudentCaseRepository.save(tutorMatchStudentCase);
            return null;
        }catch (Exception e){
            return "cancel Matching Case failed";
        }
    }
}
