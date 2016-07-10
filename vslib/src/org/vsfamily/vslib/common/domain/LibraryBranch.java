package org.vsfamily.vslib.common.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Library branch class for defining branches of libraries.
 */
@SuppressWarnings("serial")
public class LibraryBranch extends VslibBaseClass {

	private Address				address;
	private Library				library;
	private String				contactPersonName;
	private String				email;
	
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
	 * Gets the library.
	 * @return the library
	 */
	public Library getLibrary() {
		return library;
	}
	
	/**
	 * Sets the library.
	 * @param library - the library
	 */
	public void setLibrary(Library library) {
		this.library = library;
	}
	
	/**
	 * Gets the name of contact person in the library.
	 * @return the name of contact person
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}
	
	/**
	 * Sets the name of contact person in the library.
	 * @param contactPersonName - the name of contact person
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	
	/**
	 * Gets the email of contact person.
	 * @return the email of contact person
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email of contact person.
	 * @param email - the email of contact person
	 */
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
