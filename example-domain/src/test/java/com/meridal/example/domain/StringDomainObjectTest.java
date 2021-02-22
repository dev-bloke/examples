package com.meridal.example.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringDomainObjectTest {
	
	private static final String ID = "1234";
	private static final String NAME = "Martin";
	private static final String OTHER_ID = "5678";
	private static final String OTHER_NAME = "Bob";
	
	private TestObject testObject = new TestObject(ID, NAME);
	
	/**
	 * Test equals() and hashCode() with two identical objects.
	 */
	@Test
	public void testIdentical() {
		TestObject identical = new TestObject(ID, NAME);
		assertEquals(this.testObject, identical);
		assertEquals(this.testObject.hashCode(), identical.hashCode());
	}
	
	/**
	 * Test equals() and hashCode() with objects with the same ID but different content.
	 */
	@Test
	public void testSameID() {
		TestObject same = new TestObject(ID, OTHER_NAME);
		assertEquals(this.testObject, same);
		assertEquals(this.testObject.hashCode(), same.hashCode());		
	}
	
	/**
	 * Test equals() and hashCode() with objects with different IDs but the same content.
	 */
	@Test
	public void testDifferentID() {
		TestObject different = new TestObject(OTHER_ID, NAME);
		assertNotEquals(this.testObject, different);
		assertNotEquals(this.testObject.hashCode(), different.hashCode());		
	}
	
	/**
	 * Test equals() and hashCode() with objects with completely different content.
	 */
	@Test
	public void testDifferent() {
		TestObject different = new TestObject(OTHER_ID, OTHER_NAME);
		assertNotEquals(this.testObject, different);
		assertNotEquals(this.testObject.hashCode(), different.hashCode());		
	}
	
	/**
	 * Test equals() and hashCode() where one object has a null ID.
	 */
	@Test
	public void testNullID() {
		TestObject different = new TestObject(null, NAME);
		assertNotEquals(this.testObject, different);
		assertNotEquals(this.testObject.hashCode(), different.hashCode());		
	}
	
	/**
	 * Test equals() where the other object is of a different type.
	 */
	@Test
	public void testDifferentType() {
		Integer different = Integer.valueOf(1);
		assertNotEquals(this.testObject, different);		
	}
	
	/**
	 * Test equals() where the other object is null.
	 */
	@Test
	public void testNull() {
		assertNotEquals(this.testObject, null);
	}
	
	/**
	 * A test implementation of {@link StringDomainObject}.
	 * @author Martin Ingram
	 */
	private class TestObject extends StringDomainObject {

		private static final long serialVersionUID = 1L;

		@SuppressWarnings("unused")
		private String name;
		
		/**
		 * Constructor.
		 * @param id ID
		 * @param name Name
		 */
		public TestObject(String id, String name) {
			this.id = id;
			this.name = name;
		}
		
	}
}
