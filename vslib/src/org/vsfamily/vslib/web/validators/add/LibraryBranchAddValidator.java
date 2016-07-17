package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.LibraryBranch;
import org.vsfamily.vslib.web.common.validators.AddressValidator;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Validator used for validating LibraryBranch object at the time of addition.
 */
@Component
public class LibraryBranchAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	AddressValidator addressValidator;
	
	@Override
	public boolean supports(Class<?> cls) {
		return LibraryBranch.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		LibraryBranch obj = (LibraryBranch) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.libraryBranch.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 20)){
				errors.rejectValue("code", "size.libraryBranch.code");
			} else {
				
				LibraryBranch libraryBranch = this.vslibService.getLibraryBranchByCode(obj.getCode());
				
				if (libraryBranch!=null){
					errors.rejectValue("code", "unique.libraryBranch.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.libraryBranch.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 500)){
				errors.rejectValue("name", "size.libraryBranch.name");
			}
		}
		
		try {
			errors.pushNestedPath("address");
			ValidationUtils.invokeValidator(this.addressValidator,
					obj.getAddress(), errors);
		} finally {
			errors.popNestedPath();
		}
		
		if (obj.getLibrary()==null){
			errors.rejectValue("library", "required.libraryBranch.library");
		}
		
		if (obj.getContactPersonName()!=null){
			if (!this.lengthRange(obj.getContactPersonName(), 0, 255)){
				errors.rejectValue("contactPersonName", "size.libraryBranch.contactPersonName");
			}
		}
		
		if (obj.getEmail()!=null){
			if (!this.lengthRange(obj.getEmail(), 0, 255)){
				errors.rejectValue("email", "size.libraryBranch.email");
			}
			
			if (obj.getEmail().length()>1){
				if (!this.isEmail(obj.getEmail())){
					errors.rejectValue("email", "format.libraryBranch.email");
				}
			}
		}
	}
}
