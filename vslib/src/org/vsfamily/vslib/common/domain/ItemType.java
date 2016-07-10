package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * ItemType class use for grouping Items.
 */
@SuppressWarnings("serial")
public class ItemType extends VslibBaseClass {

	private Long			maximumCheckOutPeriod = new Long(0);
	private Long			maximumHoldPeriod = new Long(0);
	private Long			maximumReservePeriod = new Long(0);
	
	
	/**
	 * Gets the maximum (allowed) check-out period.
	 * @return the maximum check-out period
	 */
	public Long getMaximumCheckOutPeriod() {
		return maximumCheckOutPeriod;
	}
	
	/**
	 * Sets the maximum (allowed) check-out period
	 * @param maximumCheckOutPeriod - the maximum check-out period 
	 */
	public void setMaximumCheckOutPeriod(Long maximumCheckOutPeriod) {
		this.maximumCheckOutPeriod = maximumCheckOutPeriod;
	}
	
	/**
	 * Gets the maximum (allowed) hold period.
	 * @return the maximum hold period
	 */
	public Long getMaximumHoldPeriod() {
		return maximumHoldPeriod;
	}
	
	/**
	 * Sets the maximum (allowed) hold period.
	 * @param maximumHoldPeriod - the maximum hold period
	 */
	public void setMaximumHoldPeriod(Long maximumHoldPeriod) {
		this.maximumHoldPeriod = maximumHoldPeriod;
	}
	
	/**
	 * Gets the maximum (allowed) reservation period.
	 * @return the maximum reservation period
	 */
	public Long getMaximumReservePeriod() {
		return maximumReservePeriod;
	}
	
	/**
	 * Sets the maximum (allowed) reservation period.
	 * @param maximumReservePeriod - the maximum reservation period
	 */
	public void setMaximumReservePeriod(Long maximumReservePeriod) {
		this.maximumReservePeriod = maximumReservePeriod;
	}
	
}
