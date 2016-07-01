package org.vsfamily.vslib.common.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class LibraryBranch extends VslibBaseClass {

	private Address				address;
	private Library				library;
	private String				contactPersonName;
	private String				email;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
