package com.meridal.examples.springbootmysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 * Recording CRUD Repository.
 * @author Martin Ingram
 */
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
