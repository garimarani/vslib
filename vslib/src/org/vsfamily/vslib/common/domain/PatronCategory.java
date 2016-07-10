package org.vsfamily.vslib.common.domain;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Patron Category class used for grouping patrons. Also, used for specifying circulation parameters for the group of patrons.
 */
@SuppressWarnings("serial")
public class PatronCategory extends VslibBaseClass {

	private Long			maximumCheckOuts = new Long(0);
	private Long			maximumCheckOutPeriod = new Long(0);
	private Long			maximumHolds = new Long(0);
	private Long 			maximumHoldPeriod = new Long(0);
	private Long			maximumReserves = new Long(0);
	private Long			maximumReservePeriod = new Long(0);
	private FineCategory	fineCategory;
	
	/**
	 * Gets the maximum number of check-out allowed.
	 * @return the maximum number check-out allowed
	 */
	public Long getMaximumCheckOuts() {
		return maximumCheckOuts;
	}
	
	/**
	 * Sets the maximum number of check-out allowed.
	 * @param maximumCheckOuts - the number of check-out allowed.
	 */
	public void setMaximumCheckOuts(Long maximumCheckOuts) {
		this.maximumCheckOuts = maximumCheckOuts;
	}
	
	/**
	 * Gets the maximum check-out period (days).
	 * @return the maximum check-out period
	 */
	public Long getMaximumCheckOutPeriod() {
		return maximumCheckOutPeriod;
	}
	
	/**
	 * Sets the maximum check-out period.
	 * @param maximumCheckOutPeriod - the maximum check-out period
	 */
	public void setMaximumCheckOutPeriod(Long maximumCheckOutPeriod) {
		this.maximumCheckOutPeriod = maximumCheckOutPeriod;
	}
	
	/**
	 * Gets the maximum number of holds permitted.
	 * @return the maximum number of holds
	 */
	public Long getMaximumHolds() {
		return maximumHolds;
	}
	
	/**
	 * Sets the maximum number of holds permitted.
	 * @param maximumHolds - the maximum number of holds.
	 */
	public void setMaximumHolds(Long maximumHolds) {
		this.maximumHolds = maximumHolds;
	}
	
	/**
	 * Gets the maximum hold period (days).
	 * @return the maximum hold period
	 */
	public Long getMaximumHoldPeriod() {
		return maximumHoldPeriod;
	}
	
	/**
	 * Sets the maximum hold period (days).
	 * @param maximumHoldPeriod
	 */
	public void setMaximumHoldPeriod(Long maximumHoldPeriod) {
		this.maximumHoldPeriod = maximumHoldPeriod;
	}
	
	/**
	 * Gets the maximum number of reservations allowed.
	 * @return the maximum number of reservations allowed
	 */
	public Long getMaximumReserves() {
		return maximumReserves;
	}
	
	/**
	 * Sets the maximum number of reservations allowed.
	 * @param maximumReserves - the maximum number of reservations
	 */
	public void setMaximumReserves(Long maximumReserves) {
		this.maximumReserves = maximumReserves;
	}
	
	/**
	 * Gets the maximum reservation period (days)
	 * @return the maximum reservation period
	 */
	public Long getMaximumReservePeriod() {
		return maximumReservePeriod;
	}
	
	/**
	 * Sets the maximum reservation period (days).
	 * @param maximumReservePeriod - the maximum reservation period
	 */
	public void setMaximumReservePeriod(Long maximumReservePeriod) {
		this.maximumReservePeriod = maximumReservePeriod;
	}
	
	/**
	 * Gets the fine category.
	 * @return the fine category
	 */
	public FineCategory getFineCategory() {
		return fineCategory;
	}
	
	/**
	 * Sets the fine category.
	 * @param fineCategory - the fine category
	 */
	public void setFineCategory(FineCategory fineCategory) {
		this.fineCategory = fineCategory;
	}
}
