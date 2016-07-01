package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToLibrary implements Converter<String, Library> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Library convert(String id) {
		try {
			return this.vslibService.getLibrary(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
