package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionDTO> getSession(@PathVariable ("sessionId") Long sessionId){
        SessionDTO sessionDTO = sessionService.getSession(sessionId);
        HttpStatus responseStatus;
        if(sessionDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(sessionDTO, responseStatus);
    }

    @DeleteMapping("/{sessionId}")
    public ResponseEntity deleteSession(@PathVariable ("sessionId") Long sessionId){
        sessionService.deleteSession(sessionId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SessionDTO>> getAllSessions(){
        List<SessionDTO> sessionDTOList = sessionService.getAllSessions();
        return new ResponseEntity<>(sessionDTOList, HttpStatus.OK);
    }
}
