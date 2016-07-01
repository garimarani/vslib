package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Vendor;

public class VendorToString implements Converter<Vendor, String>{

	@Override
	public String convert(Vendor obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}
}
