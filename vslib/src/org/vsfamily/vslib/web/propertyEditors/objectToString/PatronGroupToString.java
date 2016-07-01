package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.PatronGroup;

public class PatronGroupToString implements Converter<PatronGroup, String>{

	@Override
	public String convert(PatronGroup obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
