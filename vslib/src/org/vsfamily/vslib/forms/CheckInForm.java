package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.ItemCheckIn;

public class CheckInForm extends CheckOutForm {

	private ItemCheckIn			itemCheckIn;

	public ItemCheckIn getItemCheckIn() {
		return itemCheckIn;
	}

	public void setItemCheckIn(ItemCheckIn itemCheckIn) {
		this.itemCheckIn = itemCheckIn;
	}
}
