package org.vsfamily.vslib.web.common.propertyEditors;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.common.domain.Salutation;

public class SalutationToString implements Converter<Salutation, String>{

	@Override
	public String convert(Salutation obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
