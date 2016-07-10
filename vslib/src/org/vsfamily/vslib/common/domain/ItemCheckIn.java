package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;
import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Item Check-In class. Used for storing information when the document is checked-in.
 */
@SuppressWarnings("serial")
public class ItemCheckIn extends VslibBaseClass {

	private Item			item;
	private Patron			patron;
	private Calendar		checkOutDate;
	private Calendar		dueDate;
	private Calendar		checkInDate;
	private BigDecimal		fineAmount;
	
	/**
	 * Gets the item.
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Sets the item.
	 * @param item - the item
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Gets the patron.
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}
	
	/**
	 * Sets the patron.
	 * @param patron - the patron
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
	/**
	 * Gets the check-out date.
	 * @return the check-out date
	 */
	public Calendar getCheckOutDate() {
		return checkOutDate;
	}
	
	/**
	 * Sets the check-out date.
	 * @param checkOutDate - the check-out date
	 */
	public void setCheckOutDate(Calendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	/**
	 * Gets the due date.
	 * @return the due date
	 */
	public Calendar getDueDate() {
		return dueDate;
	}
	
	/**
	 * Sets the due date.
	 * @param dueDate - the due date
	 */
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	
	/**
	 * Gets the check-in date.
	 * @return the check-in date
	 */
	public Calendar getCheckInDate() {
		return checkInDate;
	}
	
	/**
	 * Sets the check-in date.
	 * @param checkInDate - the check-in date
	 */
	public void setCheckInDate(Calendar checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	/**
	 * Gets the fine amount.
	 * @return the fine amount
	 */
	public BigDecimal getFineAmount() {
		return fineAmount;
	}
	
	/**
	 * Sets the fine amount
	 * @param fineAmount - the fine amount
	 */
	public void setFineAmount(BigDecimal fineAmount) {
		this.fineAmount = fineAmount;
	}
	
}
