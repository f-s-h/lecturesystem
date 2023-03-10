package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.PasswordDTO;

import java.util.List;

public interface PasswordService {
    public PasswordDTO savePassword(PasswordDTO passwordDTO);
    public PasswordDTO getPassword(Long id);
    public List<PasswordDTO> getAllPasswords();
    public void deletePassword(Long id);
}
