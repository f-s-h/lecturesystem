package com.fsh.lecturesystem.entity;

import com.fsh.lecturesystem.id.CourseEnrolledUserId;
import com.fsh.lecturesystem.id.GroupAssignedUserId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GROUP_ASSIGNED_USER")
@Getter
@Setter
@NoArgsConstructor
@IdClass(GroupAssignedUserId.class)
public class GroupAssignedUserEntity {
    @Id
    private Long userId;
    @Id
    private Long groupId;

    public GroupAssignedUserEntity(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
}
