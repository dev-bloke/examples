package com.meridal.examples.kotlinspringboot.service

import com.meridal.examples.kotlinspringbootamqp.repository.RecordingRepository
import com.meridal.examples.kotlinspringbootamqp.service.RecordingService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RecordingServiceTest
    @Autowired constructor(
    val entityManager: TestEntityManager,
    val repository: RecordingRepository
    ) {

        private lateinit var recording: Recording
        private lateinit var service: RecordingService

        @BeforeEach
        fun setup() {
            service = RecordingService(repository)
            recording = Recording("David Bowie", "Lodger", "BOWLP1")
        }

        @Test
        fun `Get returns a recording`() {
            val id = saveRecording()
            val other = service.getRecording(id)
            assertThat(other).isEqualTo(recording)
        }

        @Test
        fun `Get with an invalid ID returns null`() {
            val other = service.getRecording(1234L)
            assertThat(other).isNull()
        }

        @Test
        fun `Get all recordings returns everything in the repository`() {
            saveRecording()
            val other = Recording("David Bowie", "Scary Monsters", "BOWLP2")
            entityManager.persist(other)
            entityManager.flush()
            val found = service.getAllRecordings()
            assertThat(found.count()).isEqualTo(2)
        }

        @Test
        fun `Save persists a recording`() {
            val saved = service.saveRecording(recording)
            val id = saved.id!!
            val other = entityManager.find(Recording::class.java, id)
            assertThat(other).isEqualTo(recording)
        }

        @Test
        fun `Delete by valid ID removes a recording then returns it`() {
            val id = saveRecording()
            val deleted = service.deleteRecording(id)
            val other = entityManager.find(Recording::class.java, id)
            assert(other == null)
            assertThat(deleted).isEqualTo(recording)
        }

        @Test
        fun `Delete by an invalid ID returns null`() {
            val deleted = service.deleteRecording(1234L)
            assert(deleted == null)
        }

        private fun saveRecording(): Long {
            val saved = entityManager.persist(recording)
            entityManager.flush()
            return saved.id!!
        }
}