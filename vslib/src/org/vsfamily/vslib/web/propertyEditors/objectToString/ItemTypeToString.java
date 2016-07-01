package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemType;

public class ItemTypeToString implements Converter<ItemType, String>{

	@Override
	public String convert(ItemType obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
