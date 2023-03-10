package com.fsh.lecturesystem.repository;

import com.fsh.lecturesystem.entity.LocationEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationEntity, Long> {
}
