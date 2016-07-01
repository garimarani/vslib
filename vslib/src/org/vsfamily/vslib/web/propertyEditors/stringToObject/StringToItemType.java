package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToItemType implements Converter<String, ItemType> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public ItemType convert(String id) {
		try {
			return this.vslibService.getItemType(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
