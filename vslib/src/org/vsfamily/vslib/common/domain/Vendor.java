package org.vsfamily.vslib.common.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Vendor class
 */
@SuppressWarnings("serial")
public class Vendor extends VslibBaseClass {

	private Address 		address;
	private String			email;
	
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
	 * Gets the email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 * @param email - the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
