package org.vsfamily.vslib.common.domain;

import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

@SuppressWarnings("serial")
public class ItemHold extends VslibBaseClass {

	private Item					item;
	private Patron					patron;
	private Calendar				holdDate;
	private Calendar				holdReleaseDate;
	
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
	public Calendar getHoldDate() {
		return holdDate;
	}
	public void setHoldDate(Calendar holdDate) {
		this.holdDate = holdDate;
	}
	public Calendar getHoldReleaseDate() {
		return holdReleaseDate;
	}
	public void setHoldReleaseDate(Calendar holdReleaseDate) {
		this.holdReleaseDate = holdReleaseDate;
	}
	
}
