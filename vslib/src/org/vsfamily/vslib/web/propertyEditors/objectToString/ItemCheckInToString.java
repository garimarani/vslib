package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemCheckIn;

public class ItemCheckInToString implements Converter<ItemCheckIn, String>{

	@Override
	public String convert(ItemCheckIn obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
