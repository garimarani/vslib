package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Subject;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class SubjectAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Subject.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Subject obj = (Subject) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.subject.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.subject.code");
			} else {
				
				Subject subject = this.vslibService.getSubjectByCode(obj.getCode());
				
				if (subject!=null){
					errors.rejectValue("code", "unique.subject.code");
				}
			}
			
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.subject.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 100)){
				errors.rejectValue("name", "size.subject.name");
			} else {
				
				Subject subject = this.vslibService.getSubjectByName(obj.getName());
				
				if (subject!=null){
					errors.rejectValue("name", "unique.subject.name");
				}
			}
		}
	}
}
