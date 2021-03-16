package com.meridal.examples.scalaspringboot.repository

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

import scala.collection.JavaConverters._

import com.meridal.examples.scalaspringboot.model.Recording

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner
import scala.collection.mutable.ListBuffer

@DataJpaTest
@RunWith(classOf[SpringRunner]) 
class RecordingRepositoryTest {

  @Autowired 
  var entityManager: TestEntityManager = _
  
  @Autowired 
  var repository: RecordingRepository = _

  val bowie = new Recording("David Bowie", "Lodger", "BOWLP1")
  val genesis = new Recording("Genesis", "Three Sides Live", "GENLP1")

  @Test
  def testFindById(): Unit = {
    val id = saveRecording(bowie)
    val found = repository.findById(id)
    assert(found.isPresent)
    assert(found.get() == bowie)
  }

  @Test
  def testFindAll(): Unit = {
    saveRecording(bowie)
    saveRecording(genesis)
    val found = ListBuffer.from(repository.findAll().asScala).result()
    assert(found.length == 2)
  }

  @Test
  def testSave() {
    val saved = repository.save(bowie)
    val id = saved.id
    val found = entityManager.find(classOf[Recording], id)
    assert(found == bowie)
  }

  @Test
  def testDelete() {
    val id = saveRecording(bowie)
    repository.deleteById(id)
    val other = entityManager.find(classOf[Recording], id)
    assert(other == null)
  }

  private def saveRecording(recording: Recording): Long = {
    var saved = entityManager.persist(recording)
    entityManager.flush()
    return saved.id
  }
}
