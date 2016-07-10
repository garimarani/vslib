package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Patron class.
 */
@SuppressWarnings("serial")
public class Patron extends VslibBaseClass {

	private String 					number;
	private Salutation				salutation;
	private String					firstName;
	private String					middleName;
	private String					lastName;
	private String					fatherName;
	private Calendar				dateOfBirth;
	private Gender					gender;
	private String					education;
	private Address					address;
	private Address					alternateAddress;
	private PatronCategory			category;
	private PatronGroup				group;
	private Calendar				subscriptionDate;
	private Calendar				subscriptionExpiryDate;
	private BigDecimal				subscriptionAmount;
	private String					paymentDetails;
	private String					email;
	private String					alternateEmail;
	private String					loginId;
	private String					password;
	private String					retypePassword;
	private String					role = "ROLE_PATRON";
	private String					additionalFieldsData;
	private Set<ItemCheckOut>		checkOuts;
	private Set<ItemReserve>		reserves;
	private Set<ItemHold>			holds;
	
	/**
	 * Gets the patron number.
	 * @return the patron number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets the patron number
	 * @param number - the patron number
	 */
	public void setNumber(String number) {
		this.number = number;
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
	 * Sest the first name.
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
	 * Gets the father's name.
	 * @return the father's name
	 */
	public String getFatherName() {
		return fatherName;
	}
	
	/**
	 * Sets the father's name.
	 * @param fatherName - the father's name
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	/**
	 * Gets the date of birth.
	 * @return the date of birth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	
	/**
	 * Gets the date of birth.
	 * @param dateOfBirth - the date of birth
	 */
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Gets the gender.
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 * @param gender - the gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the educational qualification.
	 * @return the educational qualification
	 */
	public String getEducation() {
		return education;
	}
	
	/**
	 * Sets the educational qualification.
	 * @param education - the educational qualification
	 */
	public void setEducation(String education) {
		this.education = education;
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
	 * Gets the alternate address.
	 * @return the alternate address
	 */
	public Address getAlternateAddress() {
		return alternateAddress;
	}
	
	/**
	 * Sets the alternate address.
	 * @param alternateAddress - the alternate address
	 */
	public void setAlternateAddress(Address alternateAddress) {
		this.alternateAddress = alternateAddress;
	}
	
	/**
	 * Gets the patron category.
	 * @return the patron category
	 */
	public PatronCategory getCategory() {
		return category;
	}
	
	/**
	 * Sets the patron category.
	 * @param category - the patron category
	 */
	public void setCategory(PatronCategory category) {
		this.category = category;
	}
	
	/**
	 * Gets the patron group.
	 * @return the patron group
	 */
	public PatronGroup getGroup() {
		return group;
	}
	
	/**
	 * Sets the patron group.
	 * @param group - the patron group
	 */
	public void setGroup(PatronGroup group) {
		this.group = group;
	}
	
	/**
	 * Gets the subscription date.
	 * @return the subscription date
	 */
	public Calendar getSubscriptionDate() {
		return subscriptionDate;
	}
	
	/**
	 * Sets the subscription date.
	 * @param subscriptionDate - the subscription date
	 */
	public void setSubscriptionDate(Calendar subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	
	/**
	 * Gets the subscription expiry date.
	 * @return the subscription expiry date
	 */
	public Calendar getSubscriptionExpiryDate() {
		return subscriptionExpiryDate;
	}
	
	/**
	 * Sets the subscription expiry date.
	 * @param subscriptionExpiryDate - the subscription expiry date
	 */
	public void setSubscriptionExpiryDate(Calendar subscriptionExpiryDate) {
		this.subscriptionExpiryDate = subscriptionExpiryDate;
	}
	
	/**
	 * Gets the subscription amount.
	 * @return the subscription amount
	 */
	public BigDecimal getSubscriptionAmount() {
		return subscriptionAmount;
	}
	
	/**
	 * Sets the subscription amount.
	 * @param subscriptionAmount - the subscription amount
	 */
	public void setSubscriptionAmount(BigDecimal subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	
	/**
	 * Gets the payment details.
	 * @return the payment details
	 */
	public String getPaymentDetails() {
		return paymentDetails;
	}
	
	/**
	 * Sets the payment details.
	 * @param paymentDetails - the payment details
	 */
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
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
	
	/**
	 * Gets the alternate email.
	 * @return the alternate email
	 */
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	/**
	 * Sets the alternate email.
	 * @param alternateEmail - the alternate email.
	 */
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	
	/**
	 * Gets the login id for the patron.
	 * @return the login id for the patron
	 */
	public String getLoginId() {
		return loginId;
	}
	
	/**
	 * Sets the login id for the patron.
	 * @param loginId - the login id for the patron
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	 * Gets the retyped password (used for resetting passwords).
	 * @return the retyped password
	 */
	public String getRetypePassword() {
		return retypePassword;
	}
	
	/**
	 * Sets the retyped password (used for resetting passwords).
	 * @param retypePassword - the retyped password
	 */
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	
	/**
	 * Gets the role.
	 * @return - the role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Sets the role.
	 * @param role - the role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Gets the additional fields data.
	 * @return the additional fields data
	 */
	public String getAdditionalFieldsData() {
		return additionalFieldsData;
	}
	
	/**
	 * Sets the additional fields data
	 * @param additionalFieldsData - the additional fields data
	 */
	public void setAdditionalFieldsData(String additionalFieldsData) {
		this.additionalFieldsData = additionalFieldsData;
	}
	
	/**
	 * Gets the list of check-outs.
	 * @return the list of check-outs
	 */
	public Set<ItemCheckOut> getCheckOuts() {
		return checkOuts;
	}
	
	/**
	 * Sets the list of check-outs.
	 * @param checkOuts - the list of check-outs
	 */
	public void setCheckOuts(Set<ItemCheckOut> checkOuts) {
		this.checkOuts = checkOuts;
	}
	
	/** 
	 * Gets the list of reserved items.
	 * @return the list of reserved items
	 */
	public Set<ItemReserve> getReserves() {
		return reserves;
	}
	
	/**
	 * Sets the list of reserved items.
	 * @param reserves - the list of reserved items
	 */
	public void setReserves(Set<ItemReserve> reserves) {
		this.reserves = reserves;
	}
	
	/**
	 * Gets the list of items on hold.
	 * @return the list of items on hold
	 */
	public Set<ItemHold> getHolds() {
		return holds;
	}
	
	/**
	 * Sets the list of items on hold.
	 * @param holds - the list of items on hold
	 */
	public void setHolds(Set<ItemHold> holds) {
		this.holds = holds;
	}
	
	@Override
	public String getName() {
		return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
	}
	
	/**
	 * Gets whether the subscription has expired.
	 * @return true if yes, false otherwise
	 */
	public boolean isSubscriptionExpired(){
		Calendar cal = Calendar.getInstance();
		if (cal.after(this.getSubscriptionExpiryDate())) return true;
		else return false;
	}
	
	@Override
	public void setAddDefaults(String user) {
		this.address.setAddDefaults(user);
		this.alternateAddress.setAddDefaults(user);
		super.setAddDefaults(user);
	}
	@Override
	public void setUpdateDefaults(String user) {
		this.address.setUpdateDefaults(user);
		this.alternateAddress.setUpdateDefaults(user);
		super.setUpdateDefaults(user);
	}
}
