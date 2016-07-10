package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Patron;
import org.vsfamily.vslib.web.common.validators.AddressValidator;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class PatronAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	AddressValidator addressValidator;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Patron.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Patron obj = (Patron) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "required.patron.number");
		
		if (obj.getNumber()!=null){
			if (!this.lengthRange(obj.getNumber(), 1, 20)){
				errors.rejectValue("number", "size.patron.number");
			}
			
			Patron patron = this.vslibService.getPatronByNumber(obj.getNumber());
			
			if (patron!=null){
				errors.rejectValue("number", "unique.patron.number");
			}
			
			if (obj.getNumber().length()>0){
				if (!this.isAlphaNumeric(obj.getNumber())){
					errors.rejectValue("number", "format.patron.number");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.patron.firstName");
		
		if (obj.getFirstName()!=null){
			if (!this.lengthRange(obj.getFirstName(), 1, 50)){
				errors.rejectValue("firstName", "size.patron.firstName");
			}
		}
		
		if (obj.getMiddleName()!=null){
			if (!this.lengthRange(obj.getMiddleName(), 0, 50)){
				errors.rejectValue("middleName", "size.patron.middleName");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.patron.lastName");
		
		if (obj.getLastName()!=null){
			if (!this.lengthRange(obj.getLastName(), 1, 50)){
				errors.rejectValue("lastName", "size.patron.lastName");
			}
		}
		
		if (obj.getFatherName()!=null){
			if (!this.lengthRange(obj.getFatherName(), 0, 100)){
				errors.rejectValue("fatherName", "size.patron.fatherName");
			}
		}
		
		if (obj.getGender()==null){
			errors.rejectValue("gender", "required.patron.gennder");
		}
		
		if (obj.getEducation()!=null){
			if (!this.lengthRange(obj.getEducation(), 0, 100)){
				errors.rejectValue("education", "size.patron.education");
			}
		}
		
		if (obj.getCategory()==null){
			errors.rejectValue("category", "required.patron.category");
		}
		
		if (obj.getGroup()==null){
			errors.rejectValue("group", "required.patron.group");
		}
		
		if (obj.getSubscriptionDate()==null){
			errors.rejectValue("subscriptionDate", "required.patron.subscriptionDate");
		}
		
		if (obj.getSubscriptionExpiryDate()==null){
			errors.rejectValue("subscriptionExpiryDate", "required.patron.subscriptionExpiryDate");
		}
		
		if (obj.getPaymentDetails()!=null){
			if (!this.lengthRange(obj.getPaymentDetails(), 0, 255)){
				errors.rejectValue("paymentDetails", "size.patron.paymentDetails");
			}
		}

		if (obj.getEmail()!=null){
			if (!this.lengthRange(obj.getEmail(), 0, 255)){
				errors.rejectValue("email", "size.patron.email");
			} else {			
				if (!this.isEmail(obj.getEmail()) && obj.getEmail().length()>0){
					errors.rejectValue("email", "format.patron.email");
				}
			}
		}

		if (obj.getAlternateEmail()!=null){
			if (!this.lengthRange(obj.getAlternateEmail(), 0, 255)){
				errors.rejectValue("alternateEmail", "size.patron.alternateEmail");
			} else {
				if (!this.isEmail(obj.getAlternateEmail()) && obj.getAlternateEmail().length()>0){
					errors.rejectValue("alternateEmail", "format.patron.alternateEmail");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "required.patron.loginId");
		
		if (obj.getLoginId()!=null){
			if (!this.lengthRange(obj.getLoginId(), 3, 10)){
				errors.rejectValue("loginId", "size.patron.loginId");
			}

			Patron patron = this.vslibService.getPatronByLoginId(obj.getLoginId());
			
			if (patron!=null){
				errors.rejectValue("loginId", "unique.patron.loginId");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.patron.password");
		
		if (obj.getPassword()!=null){
			if (!this.lengthRange(obj.getPassword(), 3, 255)){
				errors.rejectValue("password", "size.patron.password");
			}
			
			if (obj.getRetypePassword()!=null){
				if (!obj.getRetypePassword().equals(obj.getPassword())){
					errors.rejectValue("retypePassword", "value.patron.retypePassword");
				}
			}
		}

		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator,
					obj.getAddress(), errors);
		} finally {
			errors.popNestedPath();
		}

		try {
			errors.pushNestedPath("alternateAddress");
			ValidationUtils.invokeValidator(this.addressValidator,
					obj.getAlternateAddress(), errors);
		} finally {
			errors.popNestedPath();
		}
	}
}
