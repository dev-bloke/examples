package com.meridal.examples.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.meridal.examples.domain.Recording;

/**
 * Recording MongoDB Repository.
 * @author Martin Ingram
 */
public interface RecordingRepository extends MongoRepository<Recording, String> {
}
