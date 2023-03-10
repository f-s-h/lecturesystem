package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.GradeConverter;
import com.fsh.lecturesystem.dto.GradeDTO;
import com.fsh.lecturesystem.entity.GradeEntity;
import com.fsh.lecturesystem.repository.GradeRepository;
import com.fsh.lecturesystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeConverter gradeConverter;

    @Autowired
    GradeRepository gradeRepository;


    @Override
    public GradeDTO saveGrade(GradeDTO gradeDTO) {
        GradeEntity gradeEntity = gradeConverter.convertDTOtoEntity(gradeDTO);
        gradeEntity = gradeRepository.save(gradeEntity);
        return gradeConverter.convertEntityToDTO(gradeEntity);
    }

    @Override
    public GradeDTO getGrade(Long id) {
        Optional<GradeEntity> gradeEntity = gradeRepository.findById(id);
        GradeDTO gradeDto = null;
        if(gradeEntity.isPresent()){
            gradeDto = gradeConverter.convertEntityToDTO(gradeEntity.get());
        }
        return gradeDto;
    }

    @Override
    public List<GradeDTO> getAllGrades() {
        List<GradeEntity> gradeEntityList = (List<GradeEntity>) gradeRepository.findAll();
        List<GradeDTO> gradeDTOList = new ArrayList<>();
        for(GradeEntity gradeEntity : gradeEntityList){
            GradeDTO gradeDTO = gradeConverter.convertEntityToDTO(gradeEntity);
            gradeDTOList.add(gradeDTO);
        }
        return gradeDTOList;
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
