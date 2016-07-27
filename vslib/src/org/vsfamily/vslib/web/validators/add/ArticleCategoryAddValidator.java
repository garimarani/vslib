package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.ArticleCategory;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class ArticleCategoryAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return ArticleCategory.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ArticleCategory obj = (ArticleCategory) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.articleCategory.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.articleCategory.name");
			}
			
			ArticleCategory articleCategory = this.vslibService.getArticleCategoryByName(obj.getName());
			
			if (articleCategory!=null){
				errors.rejectValue("name", "unique.articleCategory.name");
			}
		}
		
		if (obj.getDescription()!=null){
			if (!this.lengthRange(obj.getDescription(), 0, 255)){
				errors.rejectValue("description", "size.articleCategory.description");
			}
		}
	}

}
