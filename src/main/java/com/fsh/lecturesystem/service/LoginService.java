package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.PasswordDTO;
import com.fsh.lecturesystem.dto.SessionDTO;

public interface LoginService {
    public SessionDTO login(Long userId, PasswordDTO passwordDTO);
}
