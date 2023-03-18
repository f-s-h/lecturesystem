package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.PasswordConverter;
import com.fsh.lecturesystem.dto.PasswordDTO;
import com.fsh.lecturesystem.dto.SessionDTO;
import com.fsh.lecturesystem.entity.PasswordEntity;
import com.fsh.lecturesystem.service.PasswordService;
import com.fsh.lecturesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
    @Autowired
    PasswordService passwordService;
    @Autowired
    SessionService sessionService;

    public SessionDTO login(Long userId, PasswordDTO passwordToCheck){
        PasswordDTO passwordDTO = passwordService.getPassword(userId);
        SessionDTO sessionDTO = null;
        if (passwordToCheck.equals(passwordDTO)){
            sessionDTO = sessionService.getSession(userId);
        }
        return sessionDTO;
    }
}
