package com.TutorCentres.TutorSystem.Student.controller;

import com.TutorCentres.TutorSystem.Student.service.StudentUserService;
import com.TutorCentres.TutorSystem.core.dto.ModifyStudentDetailsDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentMatchTutorDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentMatchTutor;
import com.TutorCentres.TutorSystem.core.entity.StudentUser;
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
            return ResultVoUtil.success("Successfully get Student Matching Tutor", studentMatchTutors);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/getStudentById")
    public ResultVO getStudentById(){
        try{
            StudentUser studentUser = studentUserService.getStudentById();
            if (ObjectUtils.isEmpty(studentUser)){
                return ResultVoUtil.error("獲取學生資料失敗");
            }
            return ResultVoUtil.success(studentUser);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/modifyStudentDetails")
    public ResultVO modifyStudentDetails(@RequestBody ModifyStudentDetailsDTO modifyStudentDetailsDTO){
        try{
            String errMsg = studentUserService.modifyStudentDetails(modifyStudentDetailsDTO);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("成功更改學生資料");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

}
