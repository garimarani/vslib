package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemCheckOut;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToItemCheckOut implements Converter<String, ItemCheckOut> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public ItemCheckOut convert(String id) {
		try {
			return this.vslibService.getItemCheckOut(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
