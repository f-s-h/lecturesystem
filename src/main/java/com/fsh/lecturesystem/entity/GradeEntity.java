package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.XSlf4j;

@Entity
@Table(name="GRADE")
@NoArgsConstructor
@Getter
@Setter
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_generator")
    @SequenceGenerator(name = "grade_generator", sequenceName = "grade_seq", allocationSize = 1)
    private Long gradeId;

    @Column(nullable = false)
    private Long courseId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private int grade;

    public GradeEntity(Long courseId, Long userId, int grade) {
        this.courseId = courseId;
        this.userId = userId;
        this.grade = grade;
    }
}
