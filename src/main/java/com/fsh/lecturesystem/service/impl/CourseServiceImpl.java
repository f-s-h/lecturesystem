package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.CourseConverter;
import com.fsh.lecturesystem.dto.CourseDTO;
import com.fsh.lecturesystem.entity.CourseEntity;
import com.fsh.lecturesystem.repository.CourseRepository;
import com.fsh.lecturesystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseConverter courseConverter;

    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity =  courseConverter.convertDTOtoEntity(courseDTO);
        courseEntity = courseRepository.save(courseEntity);
        return courseConverter.convertEntityToDTO(courseEntity);
    }

    @Override
    public CourseDTO getCourse(Long id) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(id);
        CourseDTO courseDTO = null;
        if(courseEntity.isPresent()){
            courseDTO = courseConverter.convertEntityToDTO(courseEntity.get());
        }
        return courseDTO;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<CourseEntity> entityList = (List<CourseEntity>) courseRepository.findAll();
        List<CourseDTO> courseList = new ArrayList<>();
        for(CourseEntity entity : entityList){
            CourseDTO courseDTO = courseConverter.convertEntityToDTO(entity);
            courseList.add(courseDTO);
        }

        return courseList;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
