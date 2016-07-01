package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.LibraryType;

public class LibraryTypeToString implements Converter<LibraryType, String>{

	@Override
	public String convert(LibraryType obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
