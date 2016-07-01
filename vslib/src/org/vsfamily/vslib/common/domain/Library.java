package org.vsfamily.vslib.common.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class Library extends VslibBaseClass {

	private LibraryType 			libraryType;
	private Address					address;
	private String					about;
	
	public LibraryType getLibraryType() {
		return libraryType;
	}
	public void setLibraryType(LibraryType libraryType) {
		this.libraryType = libraryType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getAbout() {
		return about;
	}
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
