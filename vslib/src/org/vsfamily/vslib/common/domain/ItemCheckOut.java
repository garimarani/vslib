package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;
import org.vsfamily.vslib.common.tools.DateAndTime;

/**
 * Item Check Out class. Used for storing information about check-out transactions.
 */
@SuppressWarnings("serial")
public class ItemCheckOut extends VslibBaseClass {

	private Item			item;
	private Patron			patron;
	private Calendar		checkOutDate;
	private Calendar		dueDate;
	private BigDecimal 		fine = new BigDecimal(0);
	
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
	 * Gets the check out date.
	 * @return the check out date
	 */
	public Calendar getCheckOutDate() {
		return checkOutDate;
	}
	
	/**
	 * Sets the check out date
	 * @param checkOutDate - the check out date
	 */
	public void setCheckOutDate(Calendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	/**
	 * Gets the due date
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
	 * Gets the fine calculated.
	 * @param checkInDate - the check-in date
	 * @return the fine amount due
	 */
	public BigDecimal getFine(Calendar checkInDate){
		
		if (checkInDate.after(this.getDueDate())) return this.fine;
		
		DateAndTime dt = new DateAndTime();
		
		int numOfDays = dt.getNumberOfCompletedDays(this.getDueDate(), checkInDate);
		
		if (this.getPatron().getCategory().getFineCategory().getRate().intValue()>0 && this.getPatron().getCategory().getFineCategory().getDays().intValue()>0){
			fine = new BigDecimal(numOfDays);
			
			fine = fine.multiply(this.getPatron().getCategory().getFineCategory().getRate());
			
			fine = fine.divide(new BigDecimal(this.getPatron().getCategory().getFineCategory().getDays()), 0, RoundingMode.HALF_UP);
		}
		
		return fine;
	}
}
