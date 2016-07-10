package org.vsfamily.vslib.common.domain;

import java.util.Calendar;

import org.vsfamily.vslib.common.VslibBaseClass;

/** 
 * ItemReserve class for storing information about item reservations.
 */
@SuppressWarnings("serial")
public class ItemReserve extends VslibBaseClass {

	private Item			item;
	private Patron			patron;
	private Calendar		reserveDate;
	private Calendar		reserveReleaseDate;
	
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
	 * @return the Patron
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
	 * Gets the date of reservation.
	 * @return the reservation date
	 */
	public Calendar getReserveDate() {
		return reserveDate;
	}
	
	/**
	 * Sets the date of reservation.
	 * @param reserveDate - the date of reservation
	 */
	public void setReserveDate(Calendar reserveDate) {
		this.reserveDate = reserveDate;
	}
	
	/**
	 * Gets the date by which the reservation on the Item will be released automatically. 
	 * @return the reservation release date
	 */
	public Calendar getReserveReleaseDate() {
		return reserveReleaseDate;
	}
	
	/**
	 * Sets the date by which the reservation on the Item will be released automatically.
	 * @param reserveReleaseDate - the reservation release date
	 */
	public void setReserveReleaseDate(Calendar reserveReleaseDate) {
		this.reserveReleaseDate = reserveReleaseDate;
	}
	
}
