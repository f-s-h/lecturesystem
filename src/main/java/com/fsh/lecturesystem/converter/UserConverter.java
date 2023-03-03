package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.UserDTO;
import com.fsh.lecturesystem.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        return new UserEntity(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAddress(), userDTO.getEmail());
    }

    public UserDTO convertEntityToDTO(UserEntity userEntity){
        return new UserDTO(userEntity.getUserId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getAddress(), userEntity.getEmail());
    }
}
