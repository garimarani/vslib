package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.forms.SimpleSearchForm;

@Component
public class SimpleSearchFormValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return SimpleSearchForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SimpleSearchForm obj = (SimpleSearchForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchString", "required.ssf.searchString");
		
		if (obj.getSearchString()!=null){
			if (!this.lengthRange(obj.getSearchString(), 3, 255)){
				errors.rejectValue("searchString", "size.ssf.searchString");
			}
		}
	}

}
