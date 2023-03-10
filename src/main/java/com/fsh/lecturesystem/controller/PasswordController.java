package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.PasswordDTO;
import com.fsh.lecturesystem.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordController {

    @Autowired
    PasswordService passwordService;

    @PostMapping
    public ResponseEntity<PasswordDTO> savePassword(@RequestBody PasswordDTO passwordDTO){
        passwordDTO = passwordService.savePassword(passwordDTO);
        return new ResponseEntity<>(passwordDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{passwordId}")
    public ResponseEntity<PasswordDTO> getPassword(@PathVariable ("passwordId") Long passwordId){
        PasswordDTO passwordDTO = passwordService.getPassword(passwordId);
        HttpStatus responseStatus;
        if(passwordDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(passwordDTO, responseStatus);
    }

    @DeleteMapping("/{passwordId}")
    public ResponseEntity deletePassword(@PathVariable ("passwordId") Long passwordId){
        passwordService.deletePassword(passwordId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PasswordDTO>> getAllPasswords(){
        List<PasswordDTO> passwordDTOList = passwordService.getAllPasswords();
        return new ResponseEntity<>(passwordDTOList, HttpStatus.OK);
    }
}
