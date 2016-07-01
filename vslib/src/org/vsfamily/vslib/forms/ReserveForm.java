package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.ItemReserve;

public class ReserveForm extends CheckOutForm {

	private ItemReserve		itemReserve;

	public ItemReserve getItemReserve() {
		return itemReserve;
	}

	public void setItemReserve(ItemReserve itemReserve) {
		this.itemReserve = itemReserve;
	}
	
}
