package com.meridal.examples.repository;

import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.domain.Recording;

/**
 * Recording CRUD Repository.
 * @author Martin Ingram
 */
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
