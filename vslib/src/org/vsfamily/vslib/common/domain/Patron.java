package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import org.vsfamily.common.domain.Address;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.common.VslibBaseClass;

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
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAlternateAddress() {
		return alternateAddress;
	}
	public void setAlternateAddress(Address alternateAddress) {
		this.alternateAddress = alternateAddress;
	}
	public PatronCategory getCategory() {
		return category;
	}
	public void setCategory(PatronCategory category) {
		this.category = category;
	}
	public PatronGroup getGroup() {
		return group;
	}
	public void setGroup(PatronGroup group) {
		this.group = group;
	}
	public Calendar getSubscriptionDate() {
		return subscriptionDate;
	}
	public void setSubscriptionDate(Calendar subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	public Calendar getSubscriptionExpiryDate() {
		return subscriptionExpiryDate;
	}
	public void setSubscriptionExpiryDate(Calendar subscriptionExpiryDate) {
		this.subscriptionExpiryDate = subscriptionExpiryDate;
	}
	public BigDecimal getSubscriptionAmount() {
		return subscriptionAmount;
	}
	public void setSubscriptionAmount(BigDecimal subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	public String getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlternateEmail() {
		return alternateEmail;
	}
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAdditionalFieldsData() {
		return additionalFieldsData;
	}
	public void setAdditionalFieldsData(String additionalFieldsData) {
		this.additionalFieldsData = additionalFieldsData;
	}
	public Set<ItemCheckOut> getCheckOuts() {
		return checkOuts;
	}
	public void setCheckOuts(Set<ItemCheckOut> checkOuts) {
		this.checkOuts = checkOuts;
	}
	public Set<ItemReserve> getReserves() {
		return reserves;
	}
	public void setReserves(Set<ItemReserve> reserves) {
		this.reserves = reserves;
	}
	public Set<ItemHold> getHolds() {
		return holds;
	}
	public void setHolds(Set<ItemHold> holds) {
		this.holds = holds;
	}
	@Override
	public String getName() {
		return this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName();
	}
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
