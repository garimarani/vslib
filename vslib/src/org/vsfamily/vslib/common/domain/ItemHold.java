package org.vsfamily.vslib.common.domain;

import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

/**
 * Item Hold class. Used for storing information about items on hold.
 */
@SuppressWarnings("serial")
public class ItemHold extends VslibBaseClass {

	private Item					item;
	private Patron					patron;
	private Calendar				holdDate;
	private Calendar				holdReleaseDate;
	
	/**
	 * Gets the Item.
	 * @return the Item
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Sets the Item.
	 * @param item - the Item
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	/**
	 * Gets the Patron.
	 * @return the patron
	 */
	public Patron getPatron() {
		return patron;
	}
	
	/**
	 * Sets the Patron.
	 * @param patron - the Patron
	 */
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
	/**
	 * Gets the hold date.
	 * @return the hold date
	 */
	public Calendar getHoldDate() {
		return holdDate;
	}
	
	/**
	 * Sets the hold date.
	 * @param holdDate - the hold date
	 */
	public void setHoldDate(Calendar holdDate) {
		this.holdDate = holdDate;
	}
	
	/**
	 * Gets the date by which hold on Item will be released automatically.
	 * @return - the hold release date
	 */
	public Calendar getHoldReleaseDate() {
		return holdReleaseDate;
	}
	
	/**
	 * Sets the date by which hold on Item will be released automatically.
	 * @param holdReleaseDate - the hold release date
	 */
	public void setHoldReleaseDate(Calendar holdReleaseDate) {
		this.holdReleaseDate = holdReleaseDate;
	}
	
}
