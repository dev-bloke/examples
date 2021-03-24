package com.meridal.examples.kotlinspringboot.repository

import com.meridal.examples.kotlinspringboot.model.Recording
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordingRepository: CrudRepository<Recording, Long> {
}