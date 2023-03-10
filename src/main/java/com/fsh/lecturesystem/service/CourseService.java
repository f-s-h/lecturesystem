package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    public CourseDTO saveCourse(CourseDTO courseDTO);
    public CourseDTO getCourse(Long id);
    public List<CourseDTO> getAllCourses();
    public void deleteCourse(Long id);
}
