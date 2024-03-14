package com.TutorCentres.TutorSystem.Tutor.controller;

import com.TutorCentres.TutorSystem.Tutor.service.TutorUserService;
import com.TutorCentres.TutorSystem.core.dto.TutorSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.entity.TutorListMappingEntity;
import com.TutorCentres.TutorSystem.core.entity.TutorMatchStudentCase;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tutor")
@CrossOrigin
@RestController
public class TutorController {

    @Autowired
    private TutorUserService tutorUserService;

    @PostMapping("/getTutorList")
    public ResultVO getTutorList(@RequestBody TutorSearchDTO tutorSearchDTO){
        try{
            List<TutorListMappingEntity> tutorUserVO = tutorUserService.queryTutorList(tutorSearchDTO);
            return ResultVoUtil.success(tutorUserVO);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @GetMapping("/getTutor")
    public ResultVO getTutor (@RequestParam("tutorId") Integer tutorId){
        try{
            TutorUser tutorUser = tutorUserService.getTutorById(tutorId);
            return ResultVoUtil.success(tutorUser);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('TUTOR')")
    @PostMapping("/getMatchingCase")
    public ResultVO getMatchingCase(@RequestParam("tutorId") Integer tutorId){
        try{
            List<TutorMatchStudentCase> tutorMatchStudentCases = tutorUserService.getMatchingCase(tutorId);
            return ResultVoUtil.success(tutorMatchStudentCases);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('TUTOR')")
    @PostMapping("/matchingStudentCase")
    public ResultVO mapStudentCase(@RequestParam("caseId") Integer caseId){
        try{
            String errMsg = tutorUserService.matchingStudentCase(caseId);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功申請配對");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('TUTOR')")
    @PostMapping("/cancelMatchingCase")
    public ResultVO cancelMatchingCase(@RequestParam("caseId") Integer caseId){
        try{
            String errMsg = tutorUserService.cancelMatchingCase(caseId);
            if(StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("Successfully cancel Student Matching");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }


    @PreAuthorize("hasRole('TUTOR')")
    @GetMapping("/getStudentMatching")
    public ResultVO getStudentMatching(){
        try{
            List<StudentMatchTutor> studentMatchTutor = tutorUserService.getStudentMatching();
            return ResultVoUtil.success("Successfully get Student Matching", studentMatchTutor);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }


}
