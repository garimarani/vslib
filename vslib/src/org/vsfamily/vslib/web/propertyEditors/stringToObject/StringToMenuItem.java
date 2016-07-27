package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToMenuItem implements Converter<String, MenuItem> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public MenuItem convert(String id) {
		try {
			return this.vslibService.getMenuItem(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
