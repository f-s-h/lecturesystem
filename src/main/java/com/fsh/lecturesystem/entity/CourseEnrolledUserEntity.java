package com.fsh.lecturesystem.entity;

import com.fsh.lecturesystem.id.CourseEnrolledUserId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "COURSE_ENROLLED_USER")
@Getter
@Setter
@NoArgsConstructor
@IdClass(CourseEnrolledUserId.class)
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
