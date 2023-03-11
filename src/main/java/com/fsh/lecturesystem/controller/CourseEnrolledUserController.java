package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.CourseEnrolledUserDTO;
import com.fsh.lecturesystem.service.CourseEnrolledUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courseEnrolledUser")
public class CourseEnrolledUserController {

    @Autowired
    CourseEnrolledUserService courseEnrolledUserService;

    @PostMapping
    public ResponseEntity<CourseEnrolledUserDTO> saveCourseEnrolledUser(@RequestBody CourseEnrolledUserDTO courseEnrolledUserDTO){
        courseEnrolledUserDTO = courseEnrolledUserService.saveCourseEnrolledUser(courseEnrolledUserDTO);
        return new ResponseEntity<>(courseEnrolledUserDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{courseId}")
    public ResponseEntity deleteCourseEnrolledUser(@PathVariable ("userId") Long userId, @PathVariable ("courseId") Long courseId){
        courseEnrolledUserService.deleteCourseEnrolledUser(userId, courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CourseEnrolledUserDTO>> getAllCourseEnrolledUsers(){
        List<CourseEnrolledUserDTO> courseEnrolledUserDTOList = courseEnrolledUserService.getAllCourseEnrolledUsers();
        return new ResponseEntity<>(courseEnrolledUserDTOList, HttpStatus.OK);
    }
}
