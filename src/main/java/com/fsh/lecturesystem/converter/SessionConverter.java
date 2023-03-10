package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.entity.SessionEntity;
import org.springframework.stereotype.Component;

@Component
public class SessionConverter {
    public SessionEntity convertDTOtoEntity(SessionDTO sessionDTO){
        return new SessionEntity(sessionDTO.getSession());
    }

    public SessionDTO convertEntityToDTO(SessionEntity courseEntity){
        return new SessionDTO(courseEntity.getUserId(), courseEntity.getSession());
    }

}
