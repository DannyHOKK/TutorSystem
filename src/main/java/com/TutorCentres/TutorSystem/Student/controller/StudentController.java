package com.TutorCentres.TutorSystem.Student.controller;

import com.TutorCentres.TutorSystem.Student.service.StudentUserService;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentUserService studentUserService;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/matchingTutor")
    public ResultVO studentMapTutor(@RequestParam("tutorId") Integer tutorId){
        try{
            String errMsg = studentUserService.matchingTutor(tutorId);
            if (StringUtils.isNotEmpty(errMsg)){
                return ResultVoUtil.error(errMsg);
            }
            return ResultVoUtil.success("Successfully match Tutor");
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
