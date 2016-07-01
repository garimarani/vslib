package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemCheckOut;

public class ItemCheckOutToString implements Converter<ItemCheckOut, String>{

	@Override
	public String convert(ItemCheckOut obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
