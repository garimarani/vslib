package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.ItemHold;

/**
 * HoldForm class used for generating form for putting item on hold.
 */
public class HoldForm extends CheckOutForm {

	private ItemHold itemHold;

	/**
	 * Gets the object of type ItemHold.
	 * @return the object of type ItemHold
	 */
	public ItemHold getItemHold() {
		return itemHold;
	}

	/**
	 * Sets the object of type ItemHold.
	 * @param itemHold - the object of type ItemHold
	 */
	public void setItemHold(ItemHold itemHold) {
		this.itemHold = itemHold;
	}
	
}
