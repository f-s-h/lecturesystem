package com.fsh.lecturesystem.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO {
    private Long gradeId;
    private Long courseId;
    private Long userId;
    private int grade;

    public GradeDTO(Long gradeId, Long courseId, Long userId, int grade) {
        this.gradeId = gradeId;
        this.courseId = courseId;
        this.userId = userId;
        this.grade = grade;
    }
}
