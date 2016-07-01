package org.vsfamily.vslib.web.common.propertyEditors;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.common.domain.Gender;

public class GenderToString implements Converter<Gender, String>{

	@Override
	public String convert(Gender obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
