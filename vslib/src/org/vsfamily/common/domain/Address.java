package org.vsfamily.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * 
 * Address class to be used in combination with other class which require address as one of their field.
 * 
 *
 */
@SuppressWarnings("serial")
public class Address extends VslibBaseClass {

	private String					locationOne;
	private String					locationTwo;
	private String					city;
	private String					state;
	private String					country;
	private String 					phone;
	private String					mobile;
	private String					facsimile;
	private String					web;
	private String					pin;
	
	/**
	 * Gets the locationOne.
	 * 
	 * @return the first part of location
	 */
	public String getLocationOne() {
		return locationOne;
	}
	
	/**
	 * Sets the locationOne
	 * @param locationOne - the first part of location
	 */
	public void setLocationOne(String locationOne) {
		this.locationOne = locationOne;
	}
	
	/**
	 * Gets the locationTwo
	 * @return the second part of location.
	 */
	public String getLocationTwo() {
		return locationTwo;
	}
	
	/** 
	 * Sets the locationTwo
	 * @param locationTwo - the second part of location.
	 */
	public void setLocationTwo(String locationTwo) {
		this.locationTwo = locationTwo;
	}
	
	/**
	 * Gets the city.
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 * @param city - the city.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the state.
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Sets the state.
	 * @param state - the state.
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/** 
	 * Gets the country.
	 * @return the country.
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 * @param country - the country.
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Gets the phone numbers.
	 * @return the phone numbers.
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone numbers.
	 * @param phone - the phone numbers.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Gets the mobile number.
	 * @return the mobile number.
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * Sets the mobile number.
	 * @param mobile - the mobile number.
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	/**
	 * Gets the facsimile (fax) number.
	 * @return the facsimile (fax) number.
	 */
	public String getFacsimile() {
		return facsimile;
	}
	
	/**
	 * Sets the facsimile (fax) number.
	 * @param facsimile - the facsimile (fax) number
	 */
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	
	/**
	 * Gets the website address.
	 * @return the website address.
	 */
	public String getWeb() {
		return web;
	}
	
	/**
	 * Sets the website address.
	 * @param web - the website address.
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * Gets the postal index number.
	 * @return the postal index number.
	 */
	public String getPin() {
		return pin;
	}
	
	/**
	 * Sets the postal index number.
	 * @param pin - the postal index number.
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	/**
	 * This method is used to copy the contents of one address object to another. 
	 * @param na - the new address, the contents of which are to be copied.
	 */
	public void setAddressValues(Address na){
		this.locationOne = na.getLocationOne();
		this.locationTwo = na.getLocationTwo();
		this.city = na.getCity();
		this.state = na.getState();
		this.country = na.getCountry();
		this.phone = na.getPhone();
		this.mobile = na.getMobile();
		this.facsimile = na.getFacsimile();
		this.web = na.getWeb();
		this.pin = na.getPin();
	}
	
	/**
	 * Gets the string version of the address which is used to logging purposes.
	 * @return the string version of the address.
	 */
	public String getStringAddress(){
		String str = this.locationOne;
		
		if (this.locationTwo!=null && this.locationTwo.length()>0) str = str + ", " + this.locationTwo;
		if (this.city!=null && this.city.length()>0) str = str + ", " + this.city;
		if (this.pin!=null && this.pin.length()>0) str = str + ", " + this.pin;
		if (this.state!=null && this.state.length()>0) str = str + ", " + this.state;
		if (this.country!=null && this.country.length()>0) str = str + ", " + this.country;
		if (this.phone!=null && this.phone.length()>0) str = str + ", Phone: " + this.phone;
		if (this.facsimile!=null && this.facsimile.length()>0) str = str + ", Fax: " + this.facsimile;
		if (this.web!=null && this.web.length()>0) str = str + ", Web: " + this.web;
		
		return str;
	}
}
