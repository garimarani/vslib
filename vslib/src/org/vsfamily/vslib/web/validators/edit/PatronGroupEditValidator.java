package org.vsfamily.vslib.web.validators.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.PatronGroup;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Validator used for validating patronGroup object at the time of edition.
 */
@Component
public class PatronGroupEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return PatronGroup.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PatronGroup obj = (PatronGroup) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.patronGroup.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.patronGroup.code");
			} else {
				
				PatronGroup patronGroup = this.vslibService.getPatronGroupByCode(obj.getCode());
				
				if (patronGroup!=null && !patronGroup.getId().equals(obj.getId())){
					errors.rejectValue("code", "unique.patronGroup.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.patronGroup.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.patronGroup.name");
			} else {
				
				PatronGroup patronGroup = this.vslibService.getPatronGroupByName(obj.getName());
				
				if (patronGroup!=null && !patronGroup.getId().equals(obj.getId())){
					errors.rejectValue("name", "unique.patronGroup.name");
				}
			}
		}
	}
}
