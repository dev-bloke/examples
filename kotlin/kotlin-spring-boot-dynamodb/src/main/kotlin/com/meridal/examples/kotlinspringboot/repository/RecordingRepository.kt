package com.meridal.examples.kotlinspringboot.repository

import com.meridal.examples.kotlinspringboot.model.Recording
import org.socialsignin.spring.data.dynamodb.repository.EnableScan
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
@EnableScan
interface RecordingRepository: CrudRepository<Recording, String> {
}