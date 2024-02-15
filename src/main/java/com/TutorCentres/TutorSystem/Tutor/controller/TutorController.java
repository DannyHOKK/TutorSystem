package com.TutorCentres.TutorSystem.Tutor.controller;

import com.TutorCentres.TutorSystem.Tutor.service.TutorUserService;
import com.TutorCentres.TutorSystem.core.dto.TutorSearchDTO;
import com.TutorCentres.TutorSystem.core.entity.TutorListMappingEntity;
import com.TutorCentres.TutorSystem.core.utils.ResultVoUtil;
import com.TutorCentres.TutorSystem.core.vo.ResultVO;
import com.TutorCentres.TutorSystem.core.vo.TutorUserVO;
import org.springframework.beans.factory.annotation.Autowired;
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
}
