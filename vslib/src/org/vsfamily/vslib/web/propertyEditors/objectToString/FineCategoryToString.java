package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.FineCategory;

public class FineCategoryToString implements Converter<FineCategory, String>{

	@Override
	public String convert(FineCategory obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
