package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToFineCategory implements Converter<String, FineCategory> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public FineCategory convert(String id) {
		try {
			return this.vslibService.getFineCategory(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
