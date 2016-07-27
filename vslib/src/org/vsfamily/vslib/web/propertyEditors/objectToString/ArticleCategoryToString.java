package org.vsfamily.vslib.web.propertyEditors.objectToString;

import org.springframework.core.convert.converter.Converter;
import org.vsfamily.vslib.common.domain.ArticleCategory;

public class ArticleCategoryToString implements Converter<ArticleCategory, String> {

	@Override
	public String convert(ArticleCategory obj) {
		if (obj == null) return "";
		return obj.getId().toString();
	}
}
