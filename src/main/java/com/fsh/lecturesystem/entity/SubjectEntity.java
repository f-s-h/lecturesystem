package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SUBJECTS")
@NoArgsConstructor
@Getter
@Setter
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_generator")
    @SequenceGenerator(name = "subject_generator", sequenceName = "subject_seq", allocationSize = 1)
    private Long subjectId;
    @Column(nullable = false)
    private String name;
    private String description;

    public SubjectEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
