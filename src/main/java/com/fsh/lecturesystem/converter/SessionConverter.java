package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.entity.SessionEntity;
import org.springframework.stereotype.Component;

@Component
public class SessionConverter {
    public SessionEntity convertDTOtoEntity(SessionDTO sessionDTO){
        return new SessionEntity(sessionDTO.getSession());
    }

    public SessionDTO convertEntityToDTO(SessionEntity sessionEntity){
        return new SessionDTO(sessionEntity.getUserId(), sessionEntity.getSession());
    }
}