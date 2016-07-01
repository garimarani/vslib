package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToLibraryType implements Converter<String, LibraryType> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public LibraryType convert(String id) {
		try {
			return this.vslibService.getLibraryType(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
