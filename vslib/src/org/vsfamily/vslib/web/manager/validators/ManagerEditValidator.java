package org.vsfamily.vslib.web.manager.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.manager.domain.Manager;
import org.vsfamily.vslib.web.common.validators.AddressValidator;
import org.vsfamily.vslib.web.manager.service.ManagerService;

@Component
public class ManagerEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	AddressValidator addressValidator;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Manager.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Manager obj = (Manager) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uid", "required.manager.uid");
		
		if (obj.getUid()!=null){
			if (!this.lengthRange(obj.getUid(), 1, 20)){
				errors.rejectValue("uid", "size.manager.uid");
			}
			
			if (!this.isAlphaNumeric(obj.getUid())){
				errors.rejectValue("uid", "format.manager.uid");
			}
			Manager manager = this.managerService.getManagerByUid(obj.getUid());
			if (manager!=null && !manager.getId().equals(obj.getId())){
				errors.rejectValue("uid", "unique.manager.uid");
			}
		}
		
		if (obj.getSalutation()==null){
			errors.rejectValue("salutation", "required.manager.salutation");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.manager.firstName");
		
		if (obj.getFirstName()!=null){
			if (!this.lengthRange(obj.getFirstName(), 1, 50)){
				errors.rejectValue("firstName", "size.manager.firstName");
			}
		}
		
		if (obj.getMiddleName()!=null){
			if (!this.lengthRange(obj.getMiddleName(), 0, 50)){
				errors.rejectValue("middleName", "size.manager.middleName");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.manager.lastName");
		
		if (obj.getLastName()!=null){
			if (!this.lengthRange(obj.getLastName(), 1, 50)){
				errors.rejectValue("lastName", "size.manager.lastName");
			}
		}
		
		if (obj.getEmail()!=null){
			if (!this.lengthRange(obj.getEmail(), 0, 255)){
				errors.rejectValue("email", "size.manager.email");
			}
			
			if (obj.getEmail().length()>0){
				if (!this.isEmail(obj.getEmail())){
					errors.rejectValue("email", "format.manager.email");
				}
			}
		}
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.manager.password");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypePassword", "required.manager.retypePassword");
		System.out.println("Testing");
		if (obj.getPassword()!=null && obj.getPassword().length()>0){
			if (!this.lengthRange(obj.getPassword(), 6, 255)){
				errors.rejectValue("password", "size.manager.password");
			}

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "retypePassword", "required.manager.retypePassword");
			
			if (obj.getRetypePassword()!=null){
				if (!obj.getRetypePassword().equals(obj.getRetypePassword())){
					errors.rejectValue("retypePassword", "value.manager.retypePassword");
				}
			}
		} else {
			obj.setPassword(null);
		}
		
		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator,
					obj.getAddress(), errors);
		} finally {
			errors.popNestedPath();
		}		
	}
}
