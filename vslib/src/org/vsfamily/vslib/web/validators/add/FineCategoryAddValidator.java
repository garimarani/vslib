package org.vsfamily.vslib.web.validators.add;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.FineCategory;
import org.vsfamily.vslib.web.service.VslibService;

/**
 * Validator used for validating FineCategory object at the time of addition.
 */
@Component
public class FineCategoryAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return FineCategory.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		FineCategory obj = (FineCategory) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.fineCategory.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.fineCategory.code");
			} else {
				
				FineCategory fineCategory = this.vslibService.getFineCategoryByCode(obj.getCode());
				
				if (fineCategory!=null){
					errors.rejectValue("code", "unique.fineCategory.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.fineCategory.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.fineCategory.name");
			} else {
				
				FineCategory fineCategory = this.vslibService.getFineCategoryByName(obj.getName());
				
				if (fineCategory!=null){
					errors.rejectValue("name", "unique.fineCategory.name");
				}
			}
		}
		
		if (obj.getRate()==null){
			errors.rejectValue("rate", "required.fineCategory.rate");
		} else {
			if (obj.getRate().compareTo(new BigDecimal(0.00))<0){
				errors.rejectValue("rate", "value.fineCategory.rate");
			}
		}

		if (obj.getDays()==null){
			errors.rejectValue("days", "required.fineCategory.days");
		} else {
			if (obj.getDays().longValue()<0){
				errors.rejectValue("days", "value.fineCategory.days");
			}
		}
	}
}
