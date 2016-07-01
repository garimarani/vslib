package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Patron;

public class PatronToString implements Converter<Patron, String>{

	@Override
	public String convert(Patron obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
