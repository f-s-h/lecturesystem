package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.LocationConverter;
import com.fsh.lecturesystem.dto.LocationDTO;
import com.fsh.lecturesystem.entity.LocationEntity;
import com.fsh.lecturesystem.repository.LocationRepository;
import com.fsh.lecturesystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationConverter locationConverter;

    @Autowired
    LocationRepository locationRepository;


    @Override
    public LocationDTO saveLocation(LocationDTO locationDTO) {
        LocationEntity locationEntity = locationConverter.convertDTOtoEntity(locationDTO);
        locationEntity = locationRepository.save(locationEntity);
        return locationConverter.convertEntityToDTO(locationEntity);
    }

    @Override
    public LocationDTO getLocation(Long id) {
        Optional<LocationEntity> locationEntity = locationRepository.findById(id);
        LocationDTO locationDto = null;
        if(locationEntity.isPresent()){
            locationDto = locationConverter.convertEntityToDTO(locationEntity.get());
        }
        return locationDto;
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        List<LocationEntity> locationEntityList = (List<LocationEntity>) locationRepository.findAll();
        List<LocationDTO> locationDTOList = new ArrayList<>();
        for(LocationEntity locationEntity : locationEntityList){
            LocationDTO locationDTO = locationConverter.convertEntityToDTO(locationEntity);
            locationDTOList.add(locationDTO);
        }
        return locationDTOList;
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
