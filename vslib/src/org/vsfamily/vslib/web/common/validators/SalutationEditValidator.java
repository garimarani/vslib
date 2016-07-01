package org.vsfamily.vslib.web.common.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.common.domain.Salutation;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.web.common.service.VslibCommonService;

@Component
public class SalutationEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibCommonService vslibCommonService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Salutation.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Salutation obj = (Salutation) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.salutation.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.salutation.code");
			} else {
				
				Salutation sal = this.vslibCommonService.getSalutationCode(obj.getCode());
				
				if (sal!=null && !obj.getId().equals(sal.getId())){
					errors.rejectValue("code", "unique.salutation.code");
				}
			}
		}
	}
}
