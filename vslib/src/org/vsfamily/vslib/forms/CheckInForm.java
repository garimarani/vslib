package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.ItemCheckIn;

/**
 * CheckInForm class used for generating check-in form.
 */
public class CheckInForm extends CheckOutForm {

	private ItemCheckIn			itemCheckIn;

	/**
	 * Gets the object of type ItemCheckIn.
	 * @return the object of type ItecmCheckIn
	 */
	public ItemCheckIn getItemCheckIn() {
		return itemCheckIn;
	}

	/**
	 * Sets the object of type ItemCheckIn.
	 * @param itemCheckIn - the object of type ItemCheckIn
	 */
	public void setItemCheckIn(ItemCheckIn itemCheckIn) {
		this.itemCheckIn = itemCheckIn;
	}
}
