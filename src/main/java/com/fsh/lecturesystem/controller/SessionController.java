package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.dto.UserDTO;
import com.fsh.lecturesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionDTO> saveSession(@RequestBody SessionDTO sessionDTO){
        sessionDTO = sessionService.saveSession(sessionDTO);
        return new ResponseEntity<>(sessionDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<SessionDTO> getSession(@PathVariable ("userId") Long userId){
        SessionDTO sessionDTO = sessionService.getSession(userId);
        HttpStatus responseStatus;
        if(sessionDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(sessionDTO, responseStatus);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable ("userId") Long userId){
        sessionService.deleteSession(userId);
        return ResponseEntity.noContent().build();
    }
}
