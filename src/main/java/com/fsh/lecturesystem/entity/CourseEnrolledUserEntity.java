package com.fsh.lecturesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COURSE_ENROLLED_USER")
@Getter
@Setter
@NoArgsConstructor
public class CourseEnrolledUserEntity {
    @Id
    private Long userId;
    @Id
    private Long courseId;

    public CourseEnrolledUserEntity(Long userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }
}
