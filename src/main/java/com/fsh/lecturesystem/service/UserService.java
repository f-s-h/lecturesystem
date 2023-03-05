package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    public UserDTO saveUser(UserDTO userDTO);
    public UserDTO getUser(Long userId);
    public void deleteUser(Long userId);
    public List<UserDTO> getAllUsers();
}
