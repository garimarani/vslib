package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToItem implements Converter<String, Item> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Item convert(String id) {
		try {
			return this.vslibService.getItem(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
