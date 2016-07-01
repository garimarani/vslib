package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class ItemType extends VslibBaseClass {

	private Long			maximumCheckOutPeriod = new Long(0);
	private Long			maximumHoldPeriod = new Long(0);
	private Long			maximumReservePeriod = new Long(0);
	
	public Long getMaximumCheckOutPeriod() {
		return maximumCheckOutPeriod;
	}
	public void setMaximumCheckOutPeriod(Long maximumCheckOutPeriod) {
		this.maximumCheckOutPeriod = maximumCheckOutPeriod;
	}
	public Long getMaximumHoldPeriod() {
		return maximumHoldPeriod;
	}
	public void setMaximumHoldPeriod(Long maximumHoldPeriod) {
		this.maximumHoldPeriod = maximumHoldPeriod;
	}
	public Long getMaximumReservePeriod() {
		return maximumReservePeriod;
	}
	public void setMaximumReservePeriod(Long maximumReservePeriod) {
		this.maximumReservePeriod = maximumReservePeriod;
	}
	
}
