package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.MenuItem;

public class MenuItemToString implements Converter<MenuItem, String> {

	@Override
	public String convert(MenuItem obj) {
		if (obj == null) return "";
		return obj.getId().toString();
	}

}
