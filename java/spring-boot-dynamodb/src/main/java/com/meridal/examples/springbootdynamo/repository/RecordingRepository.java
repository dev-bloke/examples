package com.meridal.examples.springbootdynamo.repository;

import com.meridal.examples.springbootdynamo.domain.Recording;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
