package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToPatronCategory implements Converter<String, PatronCategory> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public PatronCategory convert(String id) {
		try {
			return this.vslibService.getPatronCategory(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
