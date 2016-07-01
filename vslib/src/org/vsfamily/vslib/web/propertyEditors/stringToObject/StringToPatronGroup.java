package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToPatronGroup implements Converter<String, PatronGroup> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public PatronGroup convert(String id) {
		try {
			return this.vslibService.getPatronGroup(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
