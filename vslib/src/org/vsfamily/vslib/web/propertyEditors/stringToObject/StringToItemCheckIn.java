package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemCheckIn;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToItemCheckIn implements Converter<String, ItemCheckIn> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public ItemCheckIn convert(String id) {
		try {
			return this.vslibService.getItemCheckIn(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
