package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.SessionEntity;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<SessionEntity, Long> {
}
