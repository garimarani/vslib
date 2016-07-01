package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;
import org.vsfamily.vslib.common.tools.DateAndTime;

@SuppressWarnings("serial")
public class ItemCheckOut extends VslibBaseClass {

	private Item			item;
	private Patron			patron;
	private Calendar		checkOutDate;
	private Calendar		dueDate;
	private BigDecimal 		fine = new BigDecimal(0);
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	public Calendar getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Calendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Calendar getDueDate() {
		return dueDate;
	}
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
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
