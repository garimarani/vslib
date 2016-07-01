package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Item;

public class ItemToString implements Converter<Item, String>{

	@Override
	public String convert(Item obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
