package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Article;

@Component
public class ArticleValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Article.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Article obj = (Article) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required.article.title");
		
		if (obj.getTitle()!=null){
			if (!this.lengthRange(obj.getTitle(), 1, 100)){
				errors.rejectValue("title", "size.article.title");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "articleContent", "required.article.articleContent");
		
		if (obj.getCategory()==null){
			errors.rejectValue("category", "required.article.category");
		}
	}

}
