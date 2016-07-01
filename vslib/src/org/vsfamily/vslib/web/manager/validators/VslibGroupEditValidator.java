package org.vsfamily.vslib.web.manager.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.manager.domain.VslibGroup;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Component
public class VslibGroupEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	ManagerService managerService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return VslibGroup.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		VslibGroup obj = (VslibGroup) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.vslibGroup.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 20)){
				errors.rejectValue("code", "size.vslibGroup.code");
			} else {
				
				VslibGroup vslibGroup = this.managerService.getVslibGroupByCode(obj.getCode());
				
				if (vslibGroup!=null && !vslibGroup.getId().equals(obj.getId())){
					errors.rejectValue("code", "unique.vslibGroup.code");
				}
			}
			
			if (!this.isAlphaNumericWithUnderscore(obj.getCode())){
				errors.rejectValue("code", "format.vslibGroup.code");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.vslibGroup.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.vslibGroup.name");
			} else {
				
				VslibGroup vslibGroup = this.managerService.getVslibGroupByName(obj.getName());
				
				if (vslibGroup!=null && !vslibGroup.getId().equals(obj.getId())){
					errors.rejectValue("name", "unique.vslibGroup.name");
				}
			}
		}
	}
}
