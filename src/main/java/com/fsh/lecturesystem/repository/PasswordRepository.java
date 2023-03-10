package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.PasswordEntity;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<PasswordEntity, Long> {
}
