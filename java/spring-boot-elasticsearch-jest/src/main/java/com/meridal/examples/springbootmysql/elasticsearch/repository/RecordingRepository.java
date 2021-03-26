package com.meridal.examples.springbootmysql.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.meridal.examples.springbootmysql.elasticsearch.domain.Recording;

/**
 * Recording Repository.
 * @author Martin Ingram (a-maingram)
 */
public interface RecordingRepository extends ElasticsearchRepository<Recording, String> {
}
