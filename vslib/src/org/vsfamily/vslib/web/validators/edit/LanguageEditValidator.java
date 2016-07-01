package org.vsfamily.vslib.web.validators.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Language;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class LanguageEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Language.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Language obj = (Language) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.language.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.language.code");
			} else {
				
				Language language = this.vslibService.getLanguageByCode(obj.getCode());
				
				if (language!=null && !language.getId().equals(obj.getId())){
					errors.rejectValue("code", "unique.language.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.language.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.language.name");
			} else {
				
				Language language = this.vslibService.getLanguageByName(obj.getName());
				
				if (language!=null && !language.getId().equals(obj.getId())){
					errors.rejectValue("name", "unique.language.name");
				}
			}
		}
	}
}
