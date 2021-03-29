package com.meridal.examples.springbootelasticsearch.repository;

import com.meridal.examples.springbootelasticsearch.domain.Recording;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordingRepository extends ElasticsearchRepository<Recording, String> {
}
