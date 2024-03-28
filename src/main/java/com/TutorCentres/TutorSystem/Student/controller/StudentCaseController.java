package com.TutorCentres.TutorSystem.Student.controller;

import com.TutorCentres.TutorSystem.Student.service.StudentCaseService;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseDTO;
import com.TutorCentres.TutorSystem.core.dto.StudentCaseSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.StudentCaseMappingEntity;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.PageListVO;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import com.TutorCentres.TutorSystem.core.vo.StudentCaseMatchingVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/case")
@CrossOrigin
public class StudentCaseController {

    @Autowired
    private StudentCaseService studentCaseService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/createCase")
    public ResultVO createCase(@RequestBody StudentCaseDTO studentCaseDTO){
        try{

            String errMsg = studentCaseService.createCase(studentCaseDTO);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("successfully create Case");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PostMapping("/getStudentCaseList")
    public ResultVO getStudentCaseList (@RequestBody StudentCaseSearchDTO studentCaseSearchDTO){
        try{
            PageListVO studentCaseList = studentCaseService.getStudentCaseList(studentCaseSearchDTO);
//            if (CollectionUtils.isEmpty(studentCaseList)){
//                return ResultVoUtil.error("get student case error");
//            }
            return ResultVoUtil.success("successfully get student case", studentCaseList);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/getStudentCaseById")
    public ResultVO getStudentCaseById (){
        try{
//            List<TutorMatchStudentCase> tutorMatchStudentCases = studentCaseService.getStudentCaseById();
//            List<StudentCase> studentCaseList = studentCaseService.getStudentCaseById();
            List<StudentCaseMatchingVO> studentCaseMatchingVOS = studentCaseService.getStudentCaseById();
            return ResultVoUtil.success("成功拎到學生個案", studentCaseMatchingVOS);
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/rejectStudentCase")
    public ResultVO rejectStudentCase (@RequestParam("tutorMatchCaseId") Integer tutorMatchCaseId){
        try{
            String errMsg = studentCaseService.rejectStudentCase(tutorMatchCaseId);

            if(StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }

            return ResultVoUtil.success("成功拎到學生個案");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/acceptStudentCase")
    public ResultVO acceptStudentCase (@RequestParam("tutorMatchCaseId") Integer tutorMatchCaseId){
        try{
            String errMsg = studentCaseService.acceptStudentCase(tutorMatchCaseId);

            if(StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }

            return ResultVoUtil.success("成功拎到學生個案");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }


}
