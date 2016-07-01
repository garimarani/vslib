package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToSubject implements Converter<String, Subject> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Subject convert(String id) {
		try {
			return this.vslibService.getSubject(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
