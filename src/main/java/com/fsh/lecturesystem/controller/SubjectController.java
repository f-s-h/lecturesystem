package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.SubjectDTO;
import com.fsh.lecturesystem.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDTO> saveSubject(@RequestBody SubjectDTO subjectDTO){
        subjectDTO = subjectService.saveSubject(subjectDTO);
        return new ResponseEntity<>(subjectDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable ("subjectId") Long subjectId){
        SubjectDTO subjectDTO = subjectService.getSubject(subjectId);
        HttpStatus responseStatus;
        if(subjectDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(subjectDTO, responseStatus);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable ("subjectId") Long subjectId){
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubjects(){
        List<SubjectDTO> subjectDTOList = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectDTOList, HttpStatus.OK);
    }
}
