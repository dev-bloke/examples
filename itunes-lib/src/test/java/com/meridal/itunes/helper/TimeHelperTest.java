package com.meridal.itunes.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeHelperTest {
	
	@Test
	public void testGetMinsNull() {
		assertEquals("0:00", TimeHelper.getMinsTimeFromMillis(null));
	}
	
	@Test
	public void testGetMinsZero() {
		assertEquals("0:00", TimeHelper.getMinsTimeFromMillis(0));
	}
	
	@Test
	public void testGetMinsLessThanOne() {
		assertEquals("0:59", TimeHelper.getMinsTimeFromMillis(59000));
	}
	
	@Test
	public void testGetMinsMoreThanOne() {
		assertEquals("1:01", TimeHelper.getMinsTimeFromMillis(61000));
	}
	
	@Test
	public void testGetMinsLessThanTen() {
		assertEquals("9:10", TimeHelper.getMinsTimeFromMillis(550000));
	}
	
	@Test
	public void testGetMinsMoreThanTen() {
		assertEquals("10:30", TimeHelper.getMinsTimeFromMillis(630000));
	}
	
	@Test
	public void testGetMinsLessThanHour() {
		assertEquals("58:20", TimeHelper.getMinsTimeFromMillis(3500000));
	}
	
	@Test
	public void testGetMinsMoreThanHour() {
		assertEquals("79:41", TimeHelper.getMinsTimeFromMillis(4781000));
	}
	
	@Test
	public void testGetHoursNull() {
		assertEquals("0:00:00", TimeHelper.getHoursTimeFromMillis(null));
	}
	
	@Test
	public void testGetHoursZero() {
		assertEquals("0:00:00", TimeHelper.getHoursTimeFromMillis(0));
	}
	
	@Test
	public void testGetHoursLessThanOneMin() {
		assertEquals("0:00:59", TimeHelper.getHoursTimeFromMillis(59000));
	}
	
	@Test
	public void testGetHoursMoreThanOneMin() {
		assertEquals("0:01:01", TimeHelper.getHoursTimeFromMillis(61000));
	}
	
	@Test
	public void testGetHoursLessThanTenMins() {
		assertEquals("0:09:10", TimeHelper.getHoursTimeFromMillis(550000));
	}
	
	@Test
	public void testGetHoursMoreThanTenMins() {
		assertEquals("0:10:30", TimeHelper.getHoursTimeFromMillis(630000));
	}
	
	@Test
	public void testGetHoursLessThanHour() {
		assertEquals("0:58:20", TimeHelper.getHoursTimeFromMillis(3500000));
	}
	
	@Test
	public void testGetHoursMoreThanHour() {
		assertEquals("1:19:41", TimeHelper.getHoursTimeFromMillis(4781000));
	}

}
