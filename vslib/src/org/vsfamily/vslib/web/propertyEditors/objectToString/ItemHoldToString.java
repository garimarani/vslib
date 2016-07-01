package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemHold;

public class ItemHoldToString implements Converter<ItemHold, String>{

	@Override
	public String convert(ItemHold obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
