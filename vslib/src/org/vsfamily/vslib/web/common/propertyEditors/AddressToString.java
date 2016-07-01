package org.vsfamily.vslib.web.common.propertyEditors;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.common.domain.Address;

public class AddressToString implements Converter<Address, String>{

	@Override
	public String convert(Address obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}

}
