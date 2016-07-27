package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Article;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToArticle implements Converter<String, Article> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public Article convert(String id) {
		try {
			return this.vslibService.getArticle(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
