package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.SessionConverter;
import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.entity.SessionEntity;
import com.fsh.lecturesystem.repository.SessionRepository;
import com.fsh.lecturesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    SessionConverter sessionConverter;

    @Override
    public SessionDTO saveSession(SessionDTO sessionDTO) {
        SessionEntity sessionEntity = sessionConverter.convertDTOtoEntity(sessionDTO);
        sessionEntity = sessionRepository.save(sessionEntity);
        return sessionConverter.convertEntityToDTO(sessionEntity);
    }

    @Override
    public SessionDTO getSession(Long userId) {
        Optional<SessionEntity> sessionEntity = sessionRepository.findById(userId);
        SessionDTO sessionDTO = null;
        if (sessionEntity.isPresent()){
            sessionDTO = sessionConverter.convertEntityToDTO(sessionEntity.get());
        }
        return sessionDTO;
    }

    @Override
    public List<SessionDTO> getAllSessions() {
        List<SessionEntity> entityList = (List<SessionEntity>) sessionRepository.findAll();
        List<SessionDTO> sessionDTOList = new ArrayList<>();
        for(SessionEntity sessionEntity : entityList){
            SessionDTO sessionDTO = sessionConverter.convertEntityToDTO(sessionEntity);
            sessionDTOList.add(sessionDTO);
        }

        return sessionDTOList;
    }

    @Override
    public void deleteSession(Long userId) {
        sessionRepository.deleteById(userId);
    }
}
