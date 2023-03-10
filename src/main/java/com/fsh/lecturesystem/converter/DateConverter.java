package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.DateDTO;
import com.fsh.lecturesystem.entity.DateEntity;
import org.springframework.stereotype.Component;

@Component
public class DateConverter {
    public DateEntity convertDTOtoEntity(DateDTO dateDTO){
        return new DateEntity(dateDTO.getLocationId(), dateDTO.getDate());
    }

    public DateDTO convertEntityToDTO(DateEntity dateEntity){
        return new DateDTO(dateEntity.getDateId(), dateEntity.getLocationId(), dateEntity.getDate());
    }

}
