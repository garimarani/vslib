package org.vsfamily.vslib.common.domain;

import java.math.BigDecimal;
import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class ItemCheckIn extends VslibBaseClass {

	private Item			item;
	private Patron			patron;
	private Calendar		checkOutDate;
	private Calendar		dueDate;
	private Calendar		checkInDate;
	private BigDecimal		fineAmount;
	
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
	public Calendar getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Calendar checkInDate) {
		this.checkInDate = checkInDate;
	}
	public BigDecimal getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(BigDecimal fineAmount) {
		this.fineAmount = fineAmount;
	}
	
}
