package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToAdverts implements Converter<String, Adverts> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Adverts convert(String id) {
		try {
			return this.vslibService.getAdverts(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
