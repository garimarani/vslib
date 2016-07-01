package org.vsfamily.vslib.web.manager.propertEditors;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.manager.domain.Manager;

public class ManagerToString implements Converter<Manager, String>{

	@Override
	public String convert(Manager obj) {
		if (obj!=null) return obj.getId().toString();
		else return "";
 	}

}
