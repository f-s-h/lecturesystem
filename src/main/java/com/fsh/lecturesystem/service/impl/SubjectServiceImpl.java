package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.SubjectConverter;
import com.fsh.lecturesystem.dto.SubjectDTO;
import com.fsh.lecturesystem.entity.SubjectEntity;
import com.fsh.lecturesystem.repository.SubjectRepository;
import com.fsh.lecturesystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectConverter subjectConverter;

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        SubjectEntity subjectEntity = subjectConverter.convertDTOtoEntity(subjectDTO);
        subjectEntity = subjectRepository.save(subjectEntity);
        return subjectConverter.convertEntityToDTO(subjectEntity);
    }

    @Override
    public SubjectDTO getSubject(Long id) {
        Optional<SubjectEntity> subjectEntity = subjectRepository.findById(id);
        SubjectDTO subjectDto = null;
        if(subjectEntity.isPresent()){
            subjectDto = subjectConverter.convertEntityToDTO(subjectEntity.get());
        }
        return subjectDto;
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<SubjectEntity> subjectEntityList = (List<SubjectEntity>) subjectRepository.findAll();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for(SubjectEntity subjectEntity : subjectEntityList){
            SubjectDTO subjectDTO = subjectConverter.convertEntityToDTO(subjectEntity);
            subjectDTOList.add(subjectDTO);
        }
        return subjectDTOList;
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
