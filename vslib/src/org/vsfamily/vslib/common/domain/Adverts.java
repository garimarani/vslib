package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class Adverts extends VslibBaseClass {

	private String			location;
	private String			value;
	private boolean			published = true;
	
	/**
	 * Gets the location of the advertisement.
	 * @return the location of the advertisement
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location of the advertisement.
	 * @param location - the location of the advertisement
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the advertisement code.
	 * @return the advertisement code
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the advertisement code.
	 * @param value - the advertisement code
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets whether the advertisement is published or not.
	 * @return true if published, false otherwise
	 */
	public boolean isPublished() {
		return published;
	}

	/**
	 * Sets whether the advertisement is published or not.
	 * @param published - true if published, false otherwise
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}
}
