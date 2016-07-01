package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.PatronCategory;

public class PatronCategoryToString implements Converter<PatronCategory, String>{

	@Override
	public String convert(PatronCategory obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
