package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.MenuItem;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class MenuItemAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return MenuItem.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MenuItem obj = (MenuItem) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.menuItem.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.menuItem.name");
			}
			
			MenuItem menuItem = this.vslibService.getMenuItemByName(obj.getName());
			
			if (menuItem!=null){
				errors.rejectValue("name", "unique.menuItem.name");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuType", "required.menuItem.menuType");
		
		if (obj.getMenuType()!=null){
			if (!this.lengthRange(obj.getMenuType(), 1, 20)){
				errors.rejectValue("menuType", "size.menuItem.menuType");
			} else {
				switch (obj.getMenuType()){
				case "externalUrl": 
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, "externalUrl", "required.menuItem.externalUrl");
					if (obj.getExternalUrl()!=null){
						if (!this.lengthRange(obj.getExternalUrl(), 1, 255)){
							errors.rejectValue("externalUrl", "size.menuItem.externalUrl");
						}
					}
					
					if (obj.getTargetWindow()!=null){
						if (!this.lengthRange(obj.getTargetWindow(), 0, 20)){
							errors.rejectValue("targetWindow", "size.menuItem.targetWindow");
						}
					} else {
						obj.setTargetWindow("_blank");
					}
					break;
				case "fixedArticle":
					if (obj.getArticle()==null){
						errors.rejectValue("article", "required.menuItem.article");
					}
					break;
				case "categoryBlog":
					if (obj.getArticleCategory()==null){
						errors.rejectValue("articleCategory", "required.menuItem.articleCategory");
					}
					break;
				default: errors.rejectValue("menuType", "required.menuItem.menuType");
					break;
				}
			}
		}
	}

}
