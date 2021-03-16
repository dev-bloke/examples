package com.meridal.examples.scalaspringboot.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import com.meridal.examples.scalaspringboot.model.Recording

@Repository 
trait RecordingRepository extends CrudRepository[Recording, Long]
