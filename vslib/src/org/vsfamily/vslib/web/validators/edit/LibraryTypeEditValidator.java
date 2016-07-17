package org.vsfamily.vslib.web.validators.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.LibraryType;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Validator used for validating LibraryType object at the time of edition.
 */
@Component
public class LibraryTypeEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return LibraryType.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		LibraryType obj = (LibraryType) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.libraryType.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.libraryType.code");
			} else {
				
				LibraryType libraryType = this.vslibService.getLibraryTypeByCode(obj.getCode());
				
				if (libraryType!=null && !libraryType.getId().equals(obj.getId())){
					errors.rejectValue("code", "unique.libraryType.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.libraryType.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.libraryType.name");
			} else {
				
				LibraryType libraryType = this.vslibService.getLibraryTypeByName(obj.getName());
				
				if (libraryType!=null && !libraryType.getId().equals(obj.getId())){
					errors.rejectValue("name", "unique.libraryType.name");
				}
			}
		}
	}
}
