package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.GroupDTO;
import com.fsh.lecturesystem.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupConverter {
    public GroupEntity convertDTOtoEntity(GroupDTO groupDTO){
        return new GroupEntity(groupDTO.getName(), groupDTO.getDescription());
    }

    public GroupDTO convertEntityToDTO(GroupEntity groupEntity){
        return new GroupDTO(groupEntity.getGroupId(), groupEntity.getName(), groupEntity.getDescription());
    }

}
