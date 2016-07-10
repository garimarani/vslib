package org.vsfamily.vslib.common.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Library class.
 */
@SuppressWarnings("serial")
public class Library extends VslibBaseClass {

	private LibraryType 			libraryType;
	private Address					address;
	private String					about;
	
	
	/**
	 * Gets the library type.
	 * @return the library type
	 */
	public LibraryType getLibraryType() {
		return libraryType;
	}
	
	/**
	 * Sets the library type.
	 * @param libraryType - the library type
	 */
	public void setLibraryType(LibraryType libraryType) {
		this.libraryType = libraryType;
	}
	
	/**
	 * Gets the address.
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 * @param address - the address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Gets the information about library.
	 * @return the information about library
	 */
	public String getAbout() {
		return about;
	}
	
	/**
	 * Sets the information about library.
	 * @param about - the information about library
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	
	@Override
	public void setAddDefaults(String user) {
		this.getAddress().setAddDefaults(user);
		super.setAddDefaults(user);
	}
	
	@Override
	public void setUpdateDefaults(String user) {
		this.getAddress().setUpdateDefaults(user);
		super.setUpdateDefaults(user);
	}
	
}
