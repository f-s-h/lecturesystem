package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.CourseDTO;
import com.fsh.lecturesystem.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {
    public CourseEntity convertDTOtoEntity(CourseDTO courseDTO){
        return new CourseEntity(courseDTO.getTitle(), courseDTO.getSemester(), courseDTO.getCredits(), courseDTO.getDescription());
    }

    public CourseDTO convertEntityToDTO(CourseEntity courseEntity){
        return new CourseDTO(courseEntity.getCourseId(), courseEntity.getTitle(), courseEntity.getSemester(), courseEntity.getCredits(), courseEntity.getDescription());
    }

}
