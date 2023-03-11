package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.CourseEnrolledUserDTO;

import java.util.List;

public interface CourseEnrolledUserService {
    public CourseEnrolledUserDTO saveCourseEnrolledUser(CourseEnrolledUserDTO courseEnrolledUserDTO);
    public CourseEnrolledUserDTO getCourseEnrolledUser(Long userId, Long courseId);
    public List<CourseEnrolledUserDTO> getAllCourseEnrolledUsers();
    public void deleteCourseEnrolledUser(Long userId, Long courseId);
}
