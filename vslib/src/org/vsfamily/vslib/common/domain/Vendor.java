package org.vsfamily.vslib.common.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class Vendor extends VslibBaseClass {

	private Address 		address;
	private String			email;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
