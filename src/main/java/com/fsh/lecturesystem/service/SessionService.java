package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.SessionDTO;

import java.util.List;

public interface SessionService {
    public SessionDTO saveSession(SessionDTO sessionDTO);
    public SessionDTO getSession(Long sessionId);
    public List<SessionDTO> getAllSessions();
    public void deleteSession(Long sessionId);
}
