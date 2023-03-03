package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.UserConverter;
import com.fsh.lecturesystem.dto.UserDTO;
import com.fsh.lecturesystem.entity.UserEntity;
import com.fsh.lecturesystem.repository.UserRepository;
import com.fsh.lecturesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        return userConverter.convertEntityToDTO(userEntity);
    }

    @Override
    public UserDTO getUser(Long userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        UserDTO userDTO = null;
        if (userEntity.isPresent()){
            userDTO = userConverter.convertEntityToDTO(userEntity.get());
        }
        return userDTO;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
