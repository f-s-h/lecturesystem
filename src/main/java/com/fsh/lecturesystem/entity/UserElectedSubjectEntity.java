package com.fsh.lecturesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_ELECTED_SUBJECT")
@Getter
@Setter
@NoArgsConstructor
public class UserElectedSubjectEntity {
    @Id
    private Long userId;
    private Long subjectId;

    public UserElectedSubjectEntity(Long userId, Long subjectId) {
        this.userId = userId;
        this.subjectId = subjectId;
    }
}
