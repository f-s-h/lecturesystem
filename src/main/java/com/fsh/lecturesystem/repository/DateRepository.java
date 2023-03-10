package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.DateEntity;
import org.springframework.data.repository.CrudRepository;

public interface DateRepository extends CrudRepository<DateEntity, Long> {
}
