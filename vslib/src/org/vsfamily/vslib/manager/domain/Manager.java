package org.vsfamily.vslib.manager.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class Manager extends VslibBaseClass {
 
	private String			uid;
	private Salutation		salutation;
	private String			firstName;
	private String			middleName;
	private String			lastName;
	private Address			address;
	private String			email;
	private String			password;
	private String			retypePassword;
	private boolean			accountNonLocked = true;
	private boolean			accountNonExpired = true;
	private boolean			enabled = true;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Salutation getSalutation() {
		return salutation;
	}
	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public void setAddDefaults(String user) {
		// TODO Auto-generated method stub
		super.setAddDefaults(user);
		this.getAddress().setAddDefaults(user);
	}
	@Override
	public void setUpdateDefaults(String user) {
		// TODO Auto-generated method stub
		super.setUpdateDefaults(user);
		this.getAddress().setUpdateDefaults(user);
	}
	@Override
	public String getName() {
		String str = this.firstName;
		if (this.middleName!=null && this.middleName.length()>0) str = str + " " + this.middleName;
		str = str + " " + this.lastName;
		this.setName(str);
		return str;
	}
}
