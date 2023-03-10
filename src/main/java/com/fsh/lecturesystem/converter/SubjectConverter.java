package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.SubjectDTO;
import com.fsh.lecturesystem.entity.SubjectEntity;
import org.springframework.stereotype.Component;

@Component
public class SubjectConverter {
    public SubjectEntity convertDTOtoEntity(SubjectDTO subjectDTO){
        return new SubjectEntity(subjectDTO.getName(), subjectDTO.getDescription());
    }

    public SubjectDTO convertEntityToDTO(SubjectEntity subjectEntity){
        return new SubjectDTO(subjectEntity.getSubjectId(), subjectEntity.getName(), subjectEntity.getDescription());
    }

}
