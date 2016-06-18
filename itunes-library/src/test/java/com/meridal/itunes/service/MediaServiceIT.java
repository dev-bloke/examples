package com.meridal.itunes.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.meridal.itunes.domain.Directory;
import com.meridal.itunes.helper.PathHelper;

public class MediaServiceIT {
	
	private MediaService service = new MediaService();

	@Test
	public void testGetMediaDirectory() throws IOException {
		String path = PathHelper.findResourceOnClassPath("/media/first");
		Directory directory = this.service.getMediaDirectory(path);
		assertNotNull(directory);
		assertTrue(directory.hasMedia());
		assertEquals(Integer.valueOf(2), directory.getFileCount());
	}
	
	@Test
	public void testGetMediaDirectoryDoesntExist() throws IOException {
		String path = PathHelper.findResourceOnClassPath("/media") + "/wibble";
		Directory directory = this.service.getMediaDirectory(path);
		assertNull(directory);
	}
	
	@Test
	public void testGetMediaDirectories() throws IOException {
		String path = PathHelper.findResourceOnClassPath("/media");
		List<Directory> directories = this.service.getMediaDirectories(path);
		assertNotNull(directories);
		assertEquals(2, directories.size());
		for (Directory directory : directories) {
			assertTrue(directory.hasMedia());
		}
	}
	
	@Test
	public void testGetMediaDirectoriesDontExist() throws IOException {
		String path = PathHelper.findResourceOnClassPath("/media") + "/wibble";
		List<Directory> directories = this.service.getMediaDirectories(path);
		assertNotNull(directories);
		assertEquals(0, directories.size());
	}
}
