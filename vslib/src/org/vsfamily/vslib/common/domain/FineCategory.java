package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Fine Category class.
 */
@SuppressWarnings("serial")
public class FineCategory extends VslibBaseClass {

	private BigDecimal		rate = new BigDecimal(0);
	private Long			days = new Long(0);
	
	/**
	 * Gets the rate of fine.
	 * @return the rate of fine
	 */
	public BigDecimal getRate() {
		return rate;
	}
	
	/**
	 * Sets the rate of fine.
	 * @param rate - the rate of fine
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	/**
	 * Gets the number of days for which the rate of fine is applicable.
	 * @return the number of days
	 */
	public Long getDays() {
		return days;
	}
	
	/**
	 * Sets the number of days for which the rate of fine is applicable. 
	 * @param days - the number of days
	 */
	public void setDays(Long days) {
		this.days = days;
	}
	
}
