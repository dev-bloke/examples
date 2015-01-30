package com.meridal.example.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Abstract superclass for all domain objects with String IDs.
 * @author Martin Ingram
 */
public abstract class StringDomainObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
    public boolean equals(Object o) {
    	boolean result = false;
    	if (o != null && this.getClass() == o.getClass()) {
    		StringDomainObject other = (StringDomainObject) o;
    		result = Objects.equals(this.id, other.id);
    	}
    	return result;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
    	return this.id != null ? this.id.hashCode() : 0;
    }

}
