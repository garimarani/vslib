package org.vsfamily.vslib.web.validators.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Adverts;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class AdvertsEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Adverts.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Adverts obj = (Adverts) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.adverts.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.adverts.name");
			}
			
			Adverts adverts = this.vslibService.getAdvertsByName(obj.getName());
			
			if (adverts!=null && !obj.getId().equals(adverts.getId())){
				errors.rejectValue("name", "unique.adverts.name");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "required.adverts.location");
		
		if (obj.getLocation()!=null){
			if (!this.lengthRange(obj.getLocation(), 1, 20)){
				errors.rejectValue("location", "size.adverts.location");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "value", "required.adverts.value");
		
	}

}
