package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.VslibParams;

@Component
public class ParametersEmailValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return VslibParams.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		VslibParams obj = (VslibParams) target;
		
		if (obj.isEnableEmail()){
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "host", "required.vslibParams.host");
			
			if (obj.getHost()!=null){
				if (!this.lengthRange(obj.getHost(), 1, 100)){
					errors.rejectValue("host", "size.vslibParams.host");
				}
			}
			
			ValidationUtils.rejectIfEmpty(errors, "port", "required.vslibParams.port");
			
			if (obj.getPort()!=null){
				if (!this.lengthRange(obj.getPort(), 1, 5)){
					errors.rejectValue("port", "required.vslibParams.port");
				} else {
					if (!this.isNumeric(obj.getPort())){
						errors.rejectValue("port", "format.vslibParams.port");
					}
				}
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required.vslibParams.username");
			
			if (obj.getUsername()!=null){
				if (!this.lengthRange(obj.getUsername(), 1, 100)){
					errors.rejectValue("username", "size.vslibParams.username");
				}
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.vslibParams.password");
			
			if (obj.getPassword()!=null){
				if (!this.lengthRange(obj.getPassword(), 1, 100)){
					errors.rejectValue("password", "size.vslibParams.password");
				}
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromEmail", "required.vslibParams.fromEmail");
			
			if (obj.getFromEmail()!=null){
				if (!this.lengthRange(obj.getFromEmail(), 1, 100)){
					errors.rejectValue("fromEmail", "size.vslibParams.fromEmail");
				}
			}
		}
	}

}
