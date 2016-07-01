package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class FineCategory extends VslibBaseClass {

	private BigDecimal		rate = new BigDecimal(0);
	private Long			days = new Long(0);
	
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	
}
