package com.meridal.examples.scalaspringboot.service

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Before

import com.meridal.examples.scalaspringboot.model.Recording
import com.meridal.examples.scalaspringboot.repository.RecordingRepository

@DataJpaTest
@RunWith(classOf[SpringRunner]) 
class RecordingServiceTest {

  @Autowired 
  var entityManager: TestEntityManager = _
  
  @Autowired 
  var repository: RecordingRepository = _

  var service: RecordingService = _

  val bowie = new Recording("David Bowie", "Lodger", "BOWLP1")
  val genesis = new Recording("Genesis", "Three Sides Live", "GENLP1")

  @Before
  def setup() {
      service = new RecordingService(repository)
  }

  @Test
  def testGetRecording(): Unit = {
    val id = saveRecording(bowie)
    val found = service.getRecording(id)
    assert(found == bowie)
  }

  @Test
  def testGetAllRecordings(): Unit = {
    saveRecording(bowie)
    saveRecording(genesis)
    val found = service.getAllRecordings()
    assert(found.length == 2)
  }

  @Test
  def testSave() {
    val saved = service.saveRecording(bowie)
    val id = saved.id
    val found = entityManager.find(classOf[Recording], id)
    assert(found == bowie)
  }

  @Test
  def testDelete() {
    val id = saveRecording(bowie)
    service.deleteRecording(id)
    val other = entityManager.find(classOf[Recording], id)
    assert(other == null)
  }

  private def saveRecording(recording: Recording): Long = {
    var saved = entityManager.persist(recording)
    entityManager.flush()
    return saved.id
  }
  
}
