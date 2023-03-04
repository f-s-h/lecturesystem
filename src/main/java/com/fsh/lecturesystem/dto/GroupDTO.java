package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDTO {
    private Long groupId;
    private String groupName;
    private String description;

    public GroupDTO(Long groupId, String groupName, String description) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.description = description;
    }
}
