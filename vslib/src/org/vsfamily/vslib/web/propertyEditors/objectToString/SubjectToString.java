package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Subject;

public class SubjectToString implements Converter<Subject, String>{

	@Override
	public String convert(Subject obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
