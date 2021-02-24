package com.meridal.examples.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.meridal.examples.elasticsearch.domain.Recording;

/**
 * Recording Repository.
 * @author Martin Ingram (a-maingram)
 */
public interface RecordingRepository extends ElasticsearchRepository<Recording, String> {
}
