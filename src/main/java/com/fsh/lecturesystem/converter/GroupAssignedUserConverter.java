package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.GroupAssignedUserDTO;
import com.fsh.lecturesystem.entity.GroupAssignedUserEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupAssignedUserConverter {
    public GroupAssignedUserEntity convertDTOtoEntity(GroupAssignedUserDTO groupAssignedUserDTO){
        return new GroupAssignedUserEntity(groupAssignedUserDTO.getUserId(), groupAssignedUserDTO.getGroupId());
    }

    public GroupAssignedUserDTO convertEntityToDTO(GroupAssignedUserEntity groupAssignedUserEntity){
        return new GroupAssignedUserDTO(groupAssignedUserEntity.getUserId(), groupAssignedUserEntity.getGroupId());
    }

}
