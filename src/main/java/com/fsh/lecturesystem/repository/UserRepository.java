package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
