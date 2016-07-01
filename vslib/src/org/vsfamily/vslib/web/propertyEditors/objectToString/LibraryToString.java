package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Library;

public class LibraryToString implements Converter<Library, String>{

	@Override
	public String convert(Library obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
