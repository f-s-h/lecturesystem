package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.CourseEnrolledUserConverter;
import com.fsh.lecturesystem.dto.CourseEnrolledUserDTO;
import com.fsh.lecturesystem.entity.CourseEnrolledUserEntity;
import com.fsh.lecturesystem.repository.CourseEnrolledUserRepository;
import com.fsh.lecturesystem.service.CourseEnrolledUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseEnrolledUserServiceImpl implements CourseEnrolledUserService {

    @Autowired
    CourseEnrolledUserConverter courseEnrolledUserConverter;

    @Autowired
    CourseEnrolledUserRepository courseEnrolledUserRepository;


    @Override
    public CourseEnrolledUserDTO saveCourseEnrolledUser(CourseEnrolledUserDTO courseEnrolledUserDTO) {
        CourseEnrolledUserEntity courseEnrolledUserEntity = courseEnrolledUserConverter.convertDTOtoEntity(courseEnrolledUserDTO);
        courseEnrolledUserEntity = courseEnrolledUserRepository.save(courseEnrolledUserEntity);
        return courseEnrolledUserConverter.convertEntityToDTO(courseEnrolledUserEntity);
    }

    @Override
    public CourseEnrolledUserDTO getCourseEnrolledUser(Long userId, Long courseId) {
        Optional<CourseEnrolledUserEntity> courseEnrolledUserEntity = courseEnrolledUserRepository.getCourseEnrolledUserEntity(userId, courseId);
        CourseEnrolledUserDTO courseEnrolledUserDto = null;
        if(courseEnrolledUserEntity.isPresent()){
            courseEnrolledUserDto = courseEnrolledUserConverter.convertEntityToDTO(courseEnrolledUserEntity.get());
        }
        return courseEnrolledUserDto;
    }

    @Override
    public List<CourseEnrolledUserDTO> getAllCourseEnrolledUsers() {
        List<CourseEnrolledUserEntity> courseEnrolledUserEntityList = (List<CourseEnrolledUserEntity>) courseEnrolledUserRepository.findAll();
        List<CourseEnrolledUserDTO> courseEnrolledUserDTOList = new ArrayList<>();
        for(CourseEnrolledUserEntity courseEnrolledUserEntity : courseEnrolledUserEntityList){
            CourseEnrolledUserDTO courseEnrolledUserDTO = courseEnrolledUserConverter.convertEntityToDTO(courseEnrolledUserEntity);
            courseEnrolledUserDTOList.add(courseEnrolledUserDTO);
        }
        return courseEnrolledUserDTOList;
    }

    @Override
    public void deleteCourseEnrolledUser(Long userId, Long courseId) {
        courseEnrolledUserRepository.deleteCourseEnrolledUserEntity(userId, courseId);
    }
}
