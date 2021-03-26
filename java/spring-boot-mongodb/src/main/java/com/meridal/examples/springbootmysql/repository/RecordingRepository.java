package com.meridal.examples.springbootmysql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 * Recording MongoDB Repository.
 * @author Martin Ingram
 */
public interface RecordingRepository extends MongoRepository<Recording, String> {
}
