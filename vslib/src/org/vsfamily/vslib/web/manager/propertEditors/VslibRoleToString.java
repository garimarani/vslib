package org.vsfamily.vslib.web.manager.propertEditors;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.manager.domain.VslibRole;

public class VslibRoleToString implements Converter<VslibRole, String>{

	@Override
	public String convert(VslibRole obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
	}

}
