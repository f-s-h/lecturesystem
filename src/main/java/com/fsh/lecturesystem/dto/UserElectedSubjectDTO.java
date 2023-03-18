package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserElectedSubjectDTO {
    private Long userId;
    private Long subjectId;

    public UserElectedSubjectDTO(Long userId, Long subjectId) {
        this.userId = userId;
        this.subjectId = subjectId;
    }
}
