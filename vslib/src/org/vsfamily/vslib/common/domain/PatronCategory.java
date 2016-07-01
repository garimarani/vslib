package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class PatronCategory extends VslibBaseClass {

	private Long			maximumCheckOuts = new Long(0);
	private Long			maximumCheckOutPeriod = new Long(0);
	private Long			maximumHolds = new Long(0);
	private Long 			maximumHoldPeriod = new Long(0);
	private Long			maximumReserves = new Long(0);
	private Long			maximumReservePeriod = new Long(0);
	private FineCategory	fineCategory;
	
	public Long getMaximumCheckOuts() {
		return maximumCheckOuts;
	}
	public void setMaximumCheckOuts(Long maximumCheckOuts) {
		this.maximumCheckOuts = maximumCheckOuts;
	}
	public Long getMaximumCheckOutPeriod() {
		return maximumCheckOutPeriod;
	}
	public void setMaximumCheckOutPeriod(Long maximumCheckOutPeriod) {
		this.maximumCheckOutPeriod = maximumCheckOutPeriod;
	}
	public Long getMaximumHolds() {
		return maximumHolds;
	}
	public void setMaximumHolds(Long maximumHolds) {
		this.maximumHolds = maximumHolds;
	}
	public Long getMaximumHoldPeriod() {
		return maximumHoldPeriod;
	}
	public void setMaximumHoldPeriod(Long maximumHoldPeriod) {
		this.maximumHoldPeriod = maximumHoldPeriod;
	}
	public Long getMaximumReserves() {
		return maximumReserves;
	}
	public void setMaximumReserves(Long maximumReserves) {
		this.maximumReserves = maximumReserves;
	}
	public Long getMaximumReservePeriod() {
		return maximumReservePeriod;
	}
	public void setMaximumReservePeriod(Long maximumReservePeriod) {
		this.maximumReservePeriod = maximumReservePeriod;
	}
	public FineCategory getFineCategory() {
		return fineCategory;
	}
	public void setFineCategory(FineCategory fineCategory) {
		this.fineCategory = fineCategory;
	}
}
