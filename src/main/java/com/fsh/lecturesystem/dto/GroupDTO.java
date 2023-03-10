package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupDTO {
    private Long groupId;
    private String name;
    private String description;

    public GroupDTO(Long courseId, String name, String description) {
        this.groupId = courseId;
        this.name = name;
        this.description = description;
    }
}
