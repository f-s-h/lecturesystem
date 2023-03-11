package com.fsh.lecturesystem.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseEnrolledUserId implements Serializable {
    private Long userId;
    private Long courseId;
}

