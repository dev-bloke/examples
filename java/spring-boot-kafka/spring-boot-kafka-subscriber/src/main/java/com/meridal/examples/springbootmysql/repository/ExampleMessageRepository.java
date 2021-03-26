package com.meridal.examples.springbootmysql.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.meridal.examples.springbootmysql.domain.Recording;

/**
 * An Example Message Repository.
 */
@Repository
public class ExampleMessageRepository extends LinkedHashMap<String, Recording> {

	private static final long serialVersionUID = 1L;	
	
	public List<Recording> getAllItems() {
		return new ArrayList<>(this.values());
	}
}
