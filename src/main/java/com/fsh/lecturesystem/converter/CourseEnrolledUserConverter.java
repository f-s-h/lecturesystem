package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.CourseEnrolledUserDTO;
import com.fsh.lecturesystem.entity.CourseEnrolledUserEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseEnrolledUserConverter {
    public CourseEnrolledUserEntity convertDTOtoEntity(CourseEnrolledUserDTO courseEnrolledUserDTO){
        return new CourseEnrolledUserEntity(courseEnrolledUserDTO.getUserId(), courseEnrolledUserDTO.getCourseId());
    }

    public CourseEnrolledUserDTO convertEntityToDTO(CourseEnrolledUserEntity courseEnrolledUserEntity){
        return new CourseEnrolledUserDTO(courseEnrolledUserEntity.getUserId(), courseEnrolledUserEntity.getCourseId());
    }

}
