package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.CourseEnrolledUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseEnrolledUserRepository extends CrudRepository<CourseEnrolledUserEntity, Long> {
}
