package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.ItemHold;

public class HoldForm extends CheckOutForm {

	private ItemHold itemHold;

	public ItemHold getItemHold() {
		return itemHold;
	}

	public void setItemHold(ItemHold itemHold) {
		this.itemHold = itemHold;
	}
	
}
