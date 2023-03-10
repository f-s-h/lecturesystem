package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.GradeDTO;
import com.fsh.lecturesystem.entity.GradeEntity;
import org.springframework.stereotype.Component;

@Component
public class GradeConverter {
    public GradeEntity convertDTOtoEntity(GradeDTO gradeDTO){
        return new GradeEntity(gradeDTO.getCourseId(), gradeDTO.getUserId(), gradeDTO.getGrade());
    }

    public GradeDTO convertEntityToDTO(GradeEntity gradeEntity){
        return new GradeDTO(gradeEntity.getGradeId(), gradeEntity.getCourseId(), gradeEntity.getUserId(), gradeEntity.getGrade());
    }

}
