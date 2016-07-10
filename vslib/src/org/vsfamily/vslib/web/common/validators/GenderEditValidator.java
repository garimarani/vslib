package org.vsfamily.vslib.web.common.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.common.domain.Gender;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.web.common.service.VslibCommonService;


/**
 * Validator used for validation of gender object at the time of edition.
 */
@Component
public class GenderEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Gender.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Gender obj = (Gender) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.gender.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.gender.code");
			} else {
				
				Gender gender = this.vslibCommonService.getGenderCode(obj.getCode());
				
				if (gender!=null && !obj.getId().equals(gender.getId())){
					errors.rejectValue("code", "unique.gender.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.gender.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 20)){
				errors.rejectValue("name", "size.gender.name");
			} else {
				
				Gender gender = this.vslibCommonService.getGenderName(obj.getName());
				
				if (gender!=null && !obj.getId().equals(gender.getId())){
					errors.rejectValue("name", "unique.gender.name");
				}
			}
		}
	}
}
