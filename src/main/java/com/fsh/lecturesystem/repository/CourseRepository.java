package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity, Long> {
}
