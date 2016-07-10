package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.common.domain.Patron;

/**
 * CheckOutForm class used for generating form for CheckOut process.
 */
public class CheckOutForm {

	private boolean 			result = false;
	private String				status;
	private Object				obj;
	private String				number;
	private String				barcodeNumber;
	private String				message;
	private Patron 				patron;
	private Item				item;
	private String				user;
	private ItemCheckOut 		itemCheckOut;
	
	/**
	 * Gets the object of type ItemCheckOut.
	 * @return the object of type ItemCheckOut
	 */
	public ItemCheckOut getItemCheckOut() {
		return itemCheckOut;
	}
	
	/**
	 * Sets the object of type ItemCheckOut.
	 * @param itemCheckOut - the object of type ItemCheckOut
	 */
	public void setItemCheckOut(ItemCheckOut itemCheckOut) {
		this.itemCheckOut = itemCheckOut;
	}
	
	/**
	 * Gets the result of the transactions performed.
	 * @return true if successful, false otherwise
	 */
	public boolean isResult() {
		return result;
	}
	
	/**
	 * Sets the result of the transactions performed
	 * @param result - the result 
	 */
	public void setResult(boolean result) {
		this.result = result;
	}
	
	/**
	 * Gets the status message generated while executing instructions.
	 * @return the status message
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status message while executing instructions.
	 * @param status - the status message
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the return object.
	 * @return the return object
	 */
	public Object getObj() {
		return obj;
	}
	
	/**
	 * Sets the return object.
	 * @param obj - the return object.
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	/**
	 * Gets the patron number.
	 * @return the patron number
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Sets the patron number.
	 * @param number - the patron number
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Gets the barcode number.
	 * @return the barcode number
	 */
	public String getBarcodeNumber() {
		return barcodeNumber;
	}
	
	/**
	 * Sets the barcode number.
	 * @param barcodeNumber - the barcode number
	 */
	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}
	
	/**
	 * Gets the message.
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the message.
	 * @param message - the message
	 */
	public void setMessage(String message) {
		this.message = message;
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
	 * Get the item.
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
	 * Gets the logged in user.
	 * @return the logged in user
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Sets the logged in user.
	 * @param user - the logged in user
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
