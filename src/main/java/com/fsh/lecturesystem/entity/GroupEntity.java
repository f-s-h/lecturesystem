package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "group")
@Getter
@Setter
@NoArgsConstructor
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
    @SequenceGenerator(name = "group_generator", sequenceName = "group_seq", allocationSize = 1)
    private Long groupId;
    private String groupName;
    private String description;

    public GroupEntity(String groupName, String description) {
        this.groupName = groupName;
        this.description = description;
    }
}
