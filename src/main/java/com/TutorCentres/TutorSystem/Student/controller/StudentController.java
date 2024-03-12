package com.TutorCentres.TutorSystem.Student.controller;

import com.TutorCentres.TutorSystem.Student.service.StudentUserService;
import com.TutorCentres.TutorSystem.core.dto.StudentMatchTutorDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentUserService studentUserService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/matchingTutor")
    public ResultVO studentMapTutor(@RequestBody StudentMatchTutorDTO studentMatchTutorDTO){
        try{
            String errMsg = studentUserService.matchingTutor(studentMatchTutorDTO);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("Successfully match Tutor");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/cancelMatchingTutor")
    public ResultVO cancelMatchingTutor(@RequestParam("caseId") Integer caseId){
        try{
            String errMsg = studentUserService.cancelMatchingTutor(caseId);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("Successfully cancel Student Tutor Matching");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/getStudentMatching")
    public ResultVO getStudentMatching(){
        try{
            List<StudentMatchTutor> studentMatchTutors = studentUserService.getStudentMatching();
            if (ObjectUtils.isEmpty(studentMatchTutors)){
                return ResultVoUtil.error("get Student Matching Tutor Table failed");
            }
            return ResultVoUtil.success("Successfully get Student Matching Tutor", studentMatchTutors);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

}
