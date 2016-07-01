package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ItemHold;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToItemHold implements Converter<String, ItemHold> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public ItemHold convert(String id) {
		try {
			return this.vslibService.getItemHold(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
