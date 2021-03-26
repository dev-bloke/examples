package com.meridal.examples.kotlinspringboot.repository

import com.meridal.examples.kotlinspringboot.model.Recording
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordingRepository: MongoRepository<Recording, String> {
}