package org.vsfamily.vslib.forms;

import org.vsfamily.vslib.common.domain.ItemReserve;

/**
 * ReserveForm class used for generating form for reservation of item.
 */
public class ReserveForm extends CheckOutForm {

	private ItemReserve		itemReserve;

	/**
	 * Gets the object of type ItemReserve.
	 * @return the object of type ItemReserve
	 */
	public ItemReserve getItemReserve() {
		return itemReserve;
	}

	/**
	 * Sets the object of type ItemReserve.
	 * @param itemReserve - the object of type ItemReserve
	 */
	public void setItemReserve(ItemReserve itemReserve) {
		this.itemReserve = itemReserve;
	}
	
}
