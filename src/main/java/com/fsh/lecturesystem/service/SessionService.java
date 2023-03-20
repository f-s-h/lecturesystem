package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.SessionDTO;

import java.util.List;

public interface SessionService {
    public SessionDTO saveSession(SessionDTO sessionDTO);
    public SessionDTO getSession(Long userId);
    public void deleteSession(Long userId);
    public List<SessionDTO> getAllSessions();
}
