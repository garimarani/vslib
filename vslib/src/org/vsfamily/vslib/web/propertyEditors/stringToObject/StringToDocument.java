package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Document;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToDocument implements Converter<String, Document> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Document convert(String id) {
		try {
			return this.vslibService.getDocument(new Long(id));
		} catch (Exception e){
			return null;
		}
	}
}
