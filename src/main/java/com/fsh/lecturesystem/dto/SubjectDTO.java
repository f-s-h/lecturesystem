package com.fsh.lecturesystem.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    private Long subjectId;
    private String name;
    private String description;

    public SubjectDTO(Long subjectId, String name, String description) {
        this.subjectId = subjectId;
        this.name = name;
        this.description = description;
    }
}
