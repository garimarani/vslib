package org.vsfamily.vslib.web.manager.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.manager.domain.VslibRole;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Component
public class VslibRoleAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	ManagerService managerService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return VslibRole.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		VslibRole obj = (VslibRole) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.vslibRole.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 20)){
				errors.rejectValue("code", "size.vslibRole.code");
			} else {
				
				VslibRole vslibRole = this.managerService.getVslibRoleByCode(obj.getCode());
				
				if (vslibRole!=null){
					errors.rejectValue("code", "unique.vslibRole.code");
				}
			}
			
			if (!this.isAlphaNumericWithUnderscore(obj.getCode())){
				errors.rejectValue("code", "format.vslibRole.code");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.vslibRole.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.vslibRole.name");
			} else {
				
				VslibRole vslibRole = this.managerService.getVslibRoleByName(obj.getName());
				
				if (vslibRole!=null){
					errors.rejectValue("name", "unique.vslibRole.name");
				}
			}
		}
	}
}
