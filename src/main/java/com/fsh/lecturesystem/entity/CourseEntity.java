package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="COURSES")
@NoArgsConstructor
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", sequenceName = "course_seq", allocationSize = 1)
    private Long courseId;

    @Column(nullable = false)
    private String title;
    private int semester;
    private int credits;
    private String description;

    public CourseEntity(String title, int semester, int credits, String description) {
        this.title = title;
        this.semester = semester;
        this.credits = credits;
        this.description = description;
    }
}
