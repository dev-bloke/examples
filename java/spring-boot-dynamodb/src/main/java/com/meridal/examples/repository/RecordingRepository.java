package com.meridal.examples.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.domain.Recording;

/**
 * Recording DynamoDB Repository.
 * @author Martin Ingram
 */
@EnableScan
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
