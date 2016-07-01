package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Language;

public class LanguageToString implements Converter<Language, String>{

	@Override
	public String convert(Language obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
