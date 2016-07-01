package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemReserve;

public class ItemReserveToString implements Converter<ItemReserve, String>{

	@Override
	public String convert(ItemReserve obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
