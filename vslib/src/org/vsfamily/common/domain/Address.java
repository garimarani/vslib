package org.vsfamily.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

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
	
	public String getLocationOne() {
		return locationOne;
	}
	public void setLocationOne(String locationOne) {
		this.locationOne = locationOne;
	}
	public String getLocationTwo() {
		return locationTwo;
	}
	public void setLocationTwo(String locationTwo) {
		this.locationTwo = locationTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFacsimile() {
		return facsimile;
	}
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
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
