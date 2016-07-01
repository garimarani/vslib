package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.common.domain.Patron;

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
	
	public ItemCheckOut getItemCheckOut() {
		return itemCheckOut;
	}
	public void setItemCheckOut(ItemCheckOut itemCheckOut) {
		this.itemCheckOut = itemCheckOut;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBarcodeNumber() {
		return barcodeNumber;
	}
	public void setBarcodeNumber(String barcodeNumber) {
		this.barcodeNumber = barcodeNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Patron getPatron() {
		return patron;
	}
	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
