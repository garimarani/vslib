package org.vsfamily.vslib.web.manager.propertEditors;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.manager.domain.VslibGroup;

public class VslibGroupToString implements Converter<VslibGroup, String>{

	@Override
	public String convert(VslibGroup obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}

}
