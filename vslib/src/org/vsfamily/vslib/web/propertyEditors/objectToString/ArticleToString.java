package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.Article;

public class ArticleToString implements Converter<Article, String>{

	@Override
	public String convert(Article obj) {
		if (obj == null) return "";
		return obj.getId().toString();
	}

}
