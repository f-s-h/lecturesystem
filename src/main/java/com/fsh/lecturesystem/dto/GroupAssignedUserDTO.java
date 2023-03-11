package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupAssignedUserDTO {
    private Long userId;
    private Long groupId;

    public GroupAssignedUserDTO(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
}
