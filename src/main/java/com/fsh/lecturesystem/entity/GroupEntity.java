package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="GROUPS")
@NoArgsConstructor
@Getter
@Setter
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_generator")
    @SequenceGenerator(name = "group_generator", sequenceName = "group_seq", allocationSize = 1)
    private Long groupId;


    @Column(nullable = false)
    private String name;
    private String description;

    public GroupEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
