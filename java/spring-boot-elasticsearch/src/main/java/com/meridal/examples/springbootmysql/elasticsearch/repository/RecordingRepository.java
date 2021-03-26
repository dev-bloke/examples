package com.meridal.examples.springbootmysql.elasticsearch.repository;

import com.meridal.examples.springbootmysql.elasticsearch.domain.Recording;
import org.springframework.data.repository.CrudRepository;

/**
 * Recording Repository.
 * @author Martin Ingram (a-maingram)
 */
public interface RecordingRepository extends CrudRepository<Recording, String> {
}
