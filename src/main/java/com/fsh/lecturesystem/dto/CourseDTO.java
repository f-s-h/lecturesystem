package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
    private Long courseId;
    private String title;
    private int semester;
    private int credits;
    private String description;

    public CourseDTO(Long courseId, String title, int semester, int credits, String description) {
        this.courseId = courseId;
        this.title = title;
        this.semester = semester;
        this.credits = credits;
        this.description = description;
    }
}
