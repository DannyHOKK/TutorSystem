package com.TutorCentres.TutorSystem.Tutor.controller;

import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutor")
@CrossOrigin
public class AuthController {

    @PostMapping("/signup")
    public ResultVO signUp(@RequestBody TutorUser tutorUser){
        try{
            return ResultVoUtil.success();
        }catch (Exception e){
            return ResultVoUtil.error(e);
        }
    }
}
