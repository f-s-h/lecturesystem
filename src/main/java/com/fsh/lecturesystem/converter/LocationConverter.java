package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.LocationDTO;
import com.fsh.lecturesystem.entity.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter {
    public LocationEntity convertDTOtoEntity(LocationDTO locationDTO){
        return new LocationEntity(locationDTO.getRoom(), locationDTO.getBuilding(), locationDTO.getAddress());
    }

    public LocationDTO convertEntityToDTO(LocationEntity locationEntity){
        return new LocationDTO(locationEntity.getLocationId(), locationEntity.getRoom(), locationEntity.getBuilding(), locationEntity.getAddress());
    }

}
