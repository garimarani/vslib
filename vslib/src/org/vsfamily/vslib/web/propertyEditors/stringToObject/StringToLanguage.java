package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToLanguage implements Converter<String, Language> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Language convert(String id) {
		try {
			return this.vslibService.getLanguage(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
