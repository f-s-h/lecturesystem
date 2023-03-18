package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.CourseConverter;
import com.fsh.lecturesystem.converter.SessionConverter;
import com.fsh.lecturesystem.dto.CourseDTO;
import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.entity.CourseEntity;
import com.fsh.lecturesystem.entity.SessionEntity;
import com.fsh.lecturesystem.repository.CourseRepository;
import com.fsh.lecturesystem.repository.SessionRepository;
import com.fsh.lecturesystem.service.CourseService;
import com.fsh.lecturesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionConverter sessionConverter;

    @Autowired
    SessionRepository sessionRepository;


    @Override
    public SessionDTO saveSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = sessionConverter.convertDTOtoEntity(sessionDTO);
        sessionEntity = sessionRepository.save(sessionEntity);
        return sessionConverter.convertEntityToDTO(sessionEntity);
    }

    @Override
    public SessionDTO getSession(Long sessionId) {
        Optional<SessionEntity> sessionEntity = sessionRepository.findById(sessionId);
        SessionDTO sessionDto = null;
        if(sessionEntity.isPresent()){
            sessionDto = sessionConverter.convertEntityToDTO(sessionEntity.get());
        }
        //TODO generate random number
        return sessionDto;
    }

    @Override
    public List<SessionDTO> getAllSessions() {
        List<SessionEntity> sessionEntityList = (List<SessionEntity>) sessionRepository.findAll();
        List<SessionDTO> sessionDTOList = new ArrayList<>();
        for(SessionEntity sessionEntity : sessionEntityList){
            SessionDTO sessionDTO = sessionConverter.convertEntityToDTO(sessionEntity);
            sessionDTOList.add(sessionDTO);
        }
        return sessionDTOList;
    }

    @Override
    public void deleteSession(Long sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
