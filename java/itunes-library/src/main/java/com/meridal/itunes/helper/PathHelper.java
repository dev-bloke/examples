package com.meridal.itunes.helper;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class PathHelper {
	
	private static final String LOCALHOST = "file://localhost";
    private static final String PREFIX = "file://";
	
	private PathHelper() {
	}
	
    public static String findResourceOnClassPath(String resource) {
    	URL url = PathHelper.class.getResource(resource);
    	return cleanPath(url.getPath());
    }
    
    public static String cleanPath(String path) {
    	String clean;
    	try {
    	    clean = URLDecoder.decode(path, "UTF-8");
    	}
    	catch (UnsupportedEncodingException uee) {
    		clean = path;
    	}
    	if (clean.startsWith(LOCALHOST)) {
    		clean = clean.substring(LOCALHOST.length());
    	}
    	else if (clean.startsWith(PREFIX)) {
    		clean = clean.substring(PREFIX.length());
    	}
    	return clean;
    }  

}
