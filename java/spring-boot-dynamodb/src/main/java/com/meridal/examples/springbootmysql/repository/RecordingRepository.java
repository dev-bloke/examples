package com.meridal.examples.springbootmysql.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 * Recording DynamoDB Repository.
 * @author Martin Ingram
 */
@EnableScan
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
