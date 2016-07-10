package org.vsfamily.vslib.manager.domain;

import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Manager class.
 */
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
	
	/**
	 * Gets the unique identification number (uid).
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	
	/**
	 * Sets the unique identification number (uid).
	 * @param uid - the uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	/**
	 * Gets the salutation.
	 * @return the salutation
	 */
	public Salutation getSalutation() {
		return salutation;
	}
	
	/**
	 * Sets the salutation.
	 * @param salutation - the salutation
	 */
	public void setSalutation(Salutation salutation) {
		this.salutation = salutation;
	}
	
	/**
	 * Gets the first name.
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 * @param firstName - the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the middle name.
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * Sets the middle name.
	 * @param middleName - the middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * Gets the last name.
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 * @param lastName - the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * Gets the email id.
	 * @return the email id
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email id.
	 * @param email - the email id
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 * @param password - the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the retyped password, used for confirmation of password.
	 * @return the retyped password
	 */
	public String getRetypePassword() {
		return retypePassword;
	}
	
	/**
	 * Sets the retyped password, used for confirmation of password.
	 * @param retypePassword - the retyped password
	 */
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	
	/**
	 * Gets whether the account is non locked.
	 * @return false if the account is locked and true otherwise
	 */
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	/** 
	 * Sets whether the account is non locked.
	 * @param accountNonLocked - false if the account is locked and true otherwise
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	
	/**
	 * Gets whether the account is non expired.
	 * @return false if the account is locked and true otherwise
	 */
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	/**
	 * Sets whether the account is non expired.
	 * @param accountNonExpired - false if the account is locked and true otherwise
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	
	/**
	 * Gets whether the account is enabled.
	 * @return true if yes, false otherwise
	 */
	public boolean isEnabled() {
		return enabled;
	}
	
	/**
	 * Sets whether the account is enabled.
	 * @param enabled - true if yes, false otherwise
	 */
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
