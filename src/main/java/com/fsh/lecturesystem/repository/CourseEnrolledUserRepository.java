package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.CourseEnrolledUserEntity;
import com.fsh.lecturesystem.id.CourseEnrolledUserId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CourseEnrolledUserRepository extends CrudRepository<CourseEnrolledUserEntity, CourseEnrolledUserId> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM COURSE_ENROLLED_USER WHERE user_id = ?1 and course_id = ?2", nativeQuery = true)
    void deleteCourseEnrolledUserEntity(Long userId, Long courseId);

    @Query(value = "SELECT * FROM COURSE_ENROLLED_USER WHERE user_id = ?1 and course_id = ?2", nativeQuery = true)
    Optional<CourseEnrolledUserEntity> getCourseEnrolledUserEntity(Long userId, Long courseId);

}
