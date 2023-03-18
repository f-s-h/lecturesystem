package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.PasswordDTO;
import com.fsh.lecturesystem.dto.SessionDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
    /**
     * login returns sessionId
     */
    @GetMapping("/{userId}")
    public ResponseEntity<SessionDTO> login(@PathVariable ("userId") Long userId, @RequestBody PasswordDTO passwordDTO){
        return null;
    }
}
