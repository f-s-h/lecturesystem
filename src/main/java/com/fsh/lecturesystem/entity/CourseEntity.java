package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="COURSES")
@Getter
@Setter
@NoArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name="course_generator", sequenceName = "course_seq", allocationSize = 1)
    Long courseId;
    @Column(nullable = false)
    String title;
    String description;
    int semester;
    int credits;

    public CourseEntity(String title, String description, int semester, int credits){
        this.title = title;
        this.description = description;
        this.semester = semester;
        this.credits = credits;
    }
}
