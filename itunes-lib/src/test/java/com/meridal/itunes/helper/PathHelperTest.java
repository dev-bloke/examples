package com.meridal.itunes.helper;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathHelperTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(PathHelperTest.class);

    private static final String FILE = "/Library.xml";
	
    @Test
    public void testFindResourceOnClassPath() {
	    String path = PathHelper.findResourceOnClassPath(FILE);
	    LOG.debug("path={}", path);
	    assertNotNull(path);
    }
    
    @Test
    public void testCleanPath() throws IOException {
    	String result = PathHelper.cleanPath("/Volumes/Portable%20HD/Music/ALAC/Anathema/A%20Fine%20Day%20To%20Exit");
    	LOG.debug("{} {}", result.length(), result.toCharArray());
    }
}
