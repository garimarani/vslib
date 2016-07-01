package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Document;

public class DocumentToString implements Converter<Document, String>{

	@Override
	public String convert(Document obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
