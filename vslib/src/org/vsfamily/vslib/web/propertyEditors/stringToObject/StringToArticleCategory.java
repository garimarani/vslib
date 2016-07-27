package org.vsfamily.vslib.web.propertyEditors.stringToObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.service.VslibService;

public class StringToArticleCategory implements Converter<String, ArticleCategory> {

	@Autowired
	VslibService vslibService;
	
	@Override
	public ArticleCategory convert(String id) {
		try {
			return this.vslibService.getArticleCategory(new Long(id));
		} catch (Exception e){
			return null;
		}
	}

}
