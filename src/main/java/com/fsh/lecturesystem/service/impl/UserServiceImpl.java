package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.UserConverter;
import com.fsh.lecturesystem.dto.UserDTO;
import com.fsh.lecturesystem.entity.UserEntity;
import com.fsh.lecturesystem.repository.UserRepository;
import com.fsh.lecturesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public List<UserDTO> getAllUsers() {
        List<UserEntity> entityList = (List<UserEntity>) userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity : entityList){
            UserDTO userDTO = userConverter.convertEntityToDTO(userEntity);
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userUpdateDTO) {
        Optional<UserEntity> optUserEntity = userRepository.findById(userId);
        UserDTO userDTO = null;
        if(optUserEntity.isPresent()) {
            UserEntity userEntity = optUserEntity.get();

            if(userUpdateDTO.getAddress() != null) userEntity.setAddress(userUpdateDTO.getAddress());
            if(userUpdateDTO.getEmail() != null) userEntity.setEmail(userUpdateDTO.getEmail());
            if(userUpdateDTO.getFirstName() != null) userEntity.setFirstName(userUpdateDTO.getFirstName());
            if(userUpdateDTO.getLastName() != null) userEntity.setLastName(userUpdateDTO.getLastName());

            userRepository.save(userEntity);
            userDTO = userConverter.convertEntityToDTO(userEntity);

        }
        return userDTO;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
