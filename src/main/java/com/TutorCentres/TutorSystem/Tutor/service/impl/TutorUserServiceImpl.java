package com.TutorCentres.TutorSystem.Tutor.service.impl;

import com.TutorCentres.TutorSystem.Tutor.repository.TutorRepository;
import com.TutorCentres.TutorSystem.Tutor.service.TutorUserService;
import com.TutorCentres.TutorSystem.core.dto.TutorRegisterDTO;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorUserServiceImpl implements TutorUserService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public String signUp(TutorRegisterDTO tutorRegisterDTO) {

        TutorUser checkUserExist = tutorRepository.findAllByEmail(tutorRegisterDTO.getEmail());
        if (!ObjectUtils.isEmpty(checkUserExist)){
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

        tutorUser.setTutorAreas(areaList);
        tutorUser.setExamResult(tutorRegisterDTO.getExamResult());
        tutorUser.setCreateDate(new Date());
        tutorUser.setModifyDate(new Date());
        tutorUser.setRoles("ROLE_TUTOR");

        tutorRepository.save(tutorUser);

        return null;
    }
}
