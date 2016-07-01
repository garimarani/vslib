package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemReserve;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToItemReserve implements Converter<String, ItemReserve> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public ItemReserve convert(String id) {
		try {
			return this.vslibService.getItemReserve(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
