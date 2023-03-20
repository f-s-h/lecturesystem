package com.fsh.lecturesystem.entity;

import com.fsh.lecturesystem.id.UserElectedSubjectId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_ELECTED_SUBJECT")
@Getter
@Setter
@NoArgsConstructor
@IdClass(UserElectedSubjectId.class)
public class UserElectedSubjectEntity {
    @Id
    private Long userId;
    @Id
    private Long subjectId;

    public UserElectedSubjectEntity(Long userId, Long subjectId) {
        this.userId = userId;
        this.subjectId = subjectId;
    }
}
