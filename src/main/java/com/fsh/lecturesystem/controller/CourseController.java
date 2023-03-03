package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.CourseDTO;
import com.fsh.lecturesystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseDTO courseDTO){
        courseDTO = courseService.saveCourse(courseDTO);
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable ("courseId") Long courseId){
        CourseDTO courseDTO = courseService.getCourse(courseId);
        HttpStatus responseStatus = HttpStatus.OK;
        if(courseDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(courseDTO, responseStatus);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
        List<CourseDTO> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable ("courseId") Long courseId ){
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }


}
