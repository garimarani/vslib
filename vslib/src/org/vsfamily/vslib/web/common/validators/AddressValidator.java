package org.vsfamily.vslib.web.common.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.common.domain.Address;
import org.vsfamily.vslib.common.VslibBaseValidator;

/**
 * Validator used for validation of address object.
 */
@Component
public class AddressValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Address.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Address obj = (Address) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationOne", "required.address.locationOne");
		
		if (obj.getLocationOne()!=null){
			if (!this.lengthRange(obj.getLocationOne(), 1, 100)){
				errors.rejectValue("locationOne", "size.address.locationOne");
			}
		}
		
		if (obj.getLocationTwo()!=null){
			if (!this.lengthRange(obj.getLocationTwo(), 0, 100)){
				errors.rejectValue("locationTwo", "size.address.locationTwo");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "required.address.city");
		
		if (obj.getCity()!=null){
			if (!this.lengthRange(obj.getCity(), 1, 50)){
				errors.rejectValue("city", "size.address.city");
			}
		}
		
		if (obj.getState()!=null){
			if (!this.lengthRange(obj.getState(), 0, 50)){
				errors.rejectValue("state", "size.address.state");
			}
		}
		
		if (obj.getCountry()!=null){
			if (!this.lengthRange(obj.getCountry(), 0, 50)){
				errors.rejectValue("country", "size.address.country");
			}
		}
		
		if (obj.getPhone()!=null){
			if (!this.lengthRange(obj.getPhone(), 0, 20)){
				errors.rejectValue("phone", "size.address.phone");
			}
		}
		
		if (obj.getFacsimile()!=null){
			if (!this.lengthRange(obj.getFacsimile(), 0, 20)){
				errors.rejectValue("facsimile", "size.address.facsimile");
			}
		}
		
		if (obj.getWeb()!=null){
			if (!this.lengthRange(obj.getWeb(), 0, 255)){
				errors.rejectValue("web", "size.address.web");
			}
		}
		
		if (obj.getPin()!=null){
			if (!this.lengthRange(obj.getPin(), 0, 10)){
				errors.rejectValue("pin", "size.address.pin");
			}
			
			if (obj.getPin().length()>0){
				if (!this.isNumeric(obj.getPin())){
					errors.rejectValue("pin", "format.address.pin");
				}
			}
		}
	}

}
