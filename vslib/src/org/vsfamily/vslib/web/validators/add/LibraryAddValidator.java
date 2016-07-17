package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Library;
import org.vsfamily.vslib.web.common.validators.AddressValidator;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Validator used for validating Library object at the time of addition.
 */
@Component
public class LibraryAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Autowired
	AddressValidator addressValidator;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Library.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Library obj = (Library) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.library.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 20)){
				errors.rejectValue("code", "size.library.code");
			} else {
				
				Library library = this.vslibService.getLibraryByCode(obj.getCode());
				
				if (library!=null){
					errors.rejectValue("code", "unique.library.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.library.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 500)){
				errors.rejectValue("name", "size.library.name");
			}
		}
		
		if (obj.getLibraryType()==null){
			errors.rejectValue("libraryType", "required.library.libraryType");
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
