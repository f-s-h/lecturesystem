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
    CourseConverter courseConverter;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        CourseEntity courseEntity = courseConverter.convertDTOtoEntity(courseDTO);
        courseEntity = courseRepository.save(courseEntity);
        return courseConverter.convertEntityToDTO(courseEntity);
    }

    @Override
    public CourseDTO getCourse(Long id) {
        Optional<CourseEntity> courseEntity = courseRepository.findById(id);
        CourseDTO courseDto = null;
        if(courseEntity.isPresent()){
            courseDto = courseConverter.convertEntityToDTO(courseEntity.get());
        }
        return courseDto;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<CourseEntity> courseEntityList = (List<CourseEntity>) courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for(CourseEntity courseEntity : courseEntityList){
            CourseDTO courseDTO = courseConverter.convertEntityToDTO(courseEntity);
            courseDTOList.add(courseDTO);
        }
        return courseDTOList;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
