package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToPatron implements Converter<String, Patron> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Patron convert(String id) {
		try {
			return this.vslibService.getPatron(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
