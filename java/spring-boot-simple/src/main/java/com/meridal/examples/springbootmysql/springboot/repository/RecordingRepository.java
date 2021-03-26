package com.meridal.examples.springbootmysql.springboot.repository;

import com.meridal.examples.springbootmysql.springboot.model.Recording;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends CrudRepository<Recording, Long> {
}
