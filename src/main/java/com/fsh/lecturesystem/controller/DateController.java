package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.DateDTO;
import com.fsh.lecturesystem.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/date")
public class DateController {

    @Autowired
    DateService dateService;

    @PostMapping
    public ResponseEntity<DateDTO> saveDate(@RequestBody DateDTO dateDTO){
        dateDTO = dateService.saveDate(dateDTO);
        return new ResponseEntity<>(dateDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{dateId}")
    public ResponseEntity<DateDTO> getDate(@PathVariable ("dateId") Long dateId){
        DateDTO dateDTO = dateService.getDate(dateId);
        HttpStatus responseStatus;
        if(dateDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(dateDTO, responseStatus);
    }

    @DeleteMapping("/{dateId}")
    public ResponseEntity deleteDate(@PathVariable ("dateId") Long dateId){
        dateService.deleteDate(dateId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DateDTO>> getAllDates(){
        List<DateDTO> dateDTOList = dateService.getAllDates();
        return new ResponseEntity<>(dateDTOList, HttpStatus.OK);
    }
}
