package com.fsh.lecturesystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseDTO {
    Long courseId;
    String title;
    String description;
    int semester;
    int credits;

    public CourseDTO(Long courseId, String title, String description, int semester, int credits) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.semester = semester;
        this.credits = credits;
    }
}
