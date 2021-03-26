package com.meridal.examples.springbootmysql.elasticsearch.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import com.meridal.examples.springbootmysql.elasticsearch.domain.Recording;
import com.meridal.examples.springbootmysql.elasticsearch.test.TestFramework;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RecordingRepositoryIT extends TestFramework {
    
    public static final Logger LOG = LoggerFactory.getLogger(RecordingRepositoryIT.class);
        
    @Autowired
    private RecordingRepository repository;
    
    @Test
    public void testCRUD() {
        final String id = "999";
        Recording recording = this.createRecording(id);
        LOG.info("{}", recording);
        this.repository.save(recording);
        LOG.info("{}", recording);
        Recording other = this.repository.findById(id).orElse(null);
        LOG.info("{}", other);
        this.checkRecording(other, WRONG_YEAR);
        recording.setYear(YEAR);
        this.repository.save(recording);
        other = this.repository.findById(id).orElse(null);
        this.checkRecording(other, YEAR);
        this.repository.delete(recording);
        other = this.repository.findById(id).orElse(null);
        assertNull(other);
    }
}
