package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.GroupAssignedUserEntity;
import com.fsh.lecturesystem.id.GroupAssignedUserId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface GroupAssignedUserRepository extends CrudRepository<GroupAssignedUserEntity, GroupAssignedUserId> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM GROUP_ASSIGNED_USER WHERE user_id = ?1 and group_id = ?2", nativeQuery = true)
    void deleteGroupAssignedUserEntity(Long userId, Long groupId);

    @Query(value = "SELECT * FROM COURSE_ENROLLED_USER WHERE user_id = ?1 and group_id = ?2", nativeQuery = true)
    Optional<GroupAssignedUserEntity> getGroupAssignedUserEntity(Long userId, Long groupId);

}
