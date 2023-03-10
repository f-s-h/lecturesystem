package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.DateConverter;
import com.fsh.lecturesystem.dto.DateDTO;
import com.fsh.lecturesystem.entity.DateEntity;
import com.fsh.lecturesystem.repository.DateRepository;
import com.fsh.lecturesystem.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DateServiceImpl implements DateService {

    @Autowired
    DateConverter dateConverter;

    @Autowired
    DateRepository dateRepository;


    @Override
    public DateDTO saveDate(DateDTO dateDTO) {
        DateEntity dateEntity = dateConverter.convertDTOtoEntity(dateDTO);
        dateEntity = dateRepository.save(dateEntity);
        return dateConverter.convertEntityToDTO(dateEntity);
    }

    @Override
    public DateDTO getDate(Long id) {
        Optional<DateEntity> dateEntity = dateRepository.findById(id);
        DateDTO dateDto = null;
        if(dateEntity.isPresent()){
            dateDto = dateConverter.convertEntityToDTO(dateEntity.get());
        }
        return dateDto;
    }

    @Override
    public List<DateDTO> getAllDates() {
        List<DateEntity> dateEntityList = (List<DateEntity>) dateRepository.findAll();
        List<DateDTO> dateDTOList = new ArrayList<>();
        for(DateEntity dateEntity : dateEntityList){
            DateDTO dateDTO = dateConverter.convertEntityToDTO(dateEntity);
            dateDTOList.add(dateDTO);
        }
        return dateDTOList;
    }

    @Override
    public void deleteDate(Long id) {
        dateRepository.deleteById(id);
    }
}
