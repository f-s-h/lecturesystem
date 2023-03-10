package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.GradeDTO;
import com.fsh.lecturesystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    @PostMapping
    public ResponseEntity<GradeDTO> saveGrade(@RequestBody GradeDTO gradeDTO){
        gradeDTO = gradeService.saveGrade(gradeDTO);
        return new ResponseEntity<>(gradeDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{gradeId}")
    public ResponseEntity<GradeDTO> getGrade(@PathVariable ("gradeId") Long gradeId){
        GradeDTO gradeDTO = gradeService.getGrade(gradeId);
        HttpStatus responseStatus;
        if(gradeDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(gradeDTO, responseStatus);
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity deleteGrade(@PathVariable ("gradeId") Long gradeId){
        gradeService.deleteGrade(gradeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<GradeDTO>> getAllGrades(){
        List<GradeDTO> gradeDTOList = gradeService.getAllGrades();
        return new ResponseEntity<>(gradeDTOList, HttpStatus.OK);
    }
}
