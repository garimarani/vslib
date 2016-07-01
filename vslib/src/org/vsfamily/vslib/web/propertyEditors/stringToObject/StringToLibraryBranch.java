package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToLibraryBranch implements Converter<String, LibraryBranch> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public LibraryBranch convert(String id) {
		try {
			return this.vslibService.getLibraryBranch(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
