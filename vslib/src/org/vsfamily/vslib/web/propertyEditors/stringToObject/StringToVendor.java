package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Vendor;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToVendor implements Converter<String, Vendor> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Vendor convert(String id) {
		try {
			return this.vslibService.getVendor(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
