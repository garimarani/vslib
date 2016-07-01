package org.vsfamily.vslib.common.domain;

import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class ItemReserve extends VslibBaseClass {

	private Item			item;
	private Patron			patron;
	private Calendar		reserveDate;
	private Calendar		reserveReleaseDate;
	
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
	public Calendar getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Calendar reserveDate) {
		this.reserveDate = reserveDate;
	}
	public Calendar getReserveReleaseDate() {
		return reserveReleaseDate;
	}
	public void setReserveReleaseDate(Calendar reserveReleaseDate) {
		this.reserveReleaseDate = reserveReleaseDate;
	}
	
}
