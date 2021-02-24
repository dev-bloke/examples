package com.meridal.examples.elasticsearch.repository;

import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.elasticsearch.domain.Recording;

/**
 * Recording Repository.
 * @author Martin Ingram (a-maingram)
 */
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
