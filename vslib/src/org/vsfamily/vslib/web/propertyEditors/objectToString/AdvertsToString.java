package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Adverts;

public class AdvertsToString implements Converter<Adverts, String>{

	@Override
	public String convert(Adverts obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
