package com.meridal.examples.springbootmongo.repository;

import com.meridal.examples.springbootmongo.domain.Recording;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends MongoRepository<Recording, String> {
}
