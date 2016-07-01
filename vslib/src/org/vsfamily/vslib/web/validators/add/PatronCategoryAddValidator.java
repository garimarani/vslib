package org.vsfamily.vslib.web.validators.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.PatronCategory;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class PatronCategoryAddValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return PatronCategory.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		PatronCategory obj = (PatronCategory) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.patronCategory.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.patronCategory.code");
			} else {
				
				PatronCategory patronCategory = this.vslibService.getPatronCategoryByCode(obj.getCode());
				
				if (patronCategory!=null){
					errors.rejectValue("code", "unique.patronCategory.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.patronCategory.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.patronCategory.name");
			} else {
				
				PatronCategory patronCategory = this.vslibService.getPatronCategoryByName(obj.getName());
				
				if (patronCategory!=null){
					errors.rejectValue("name", "unique.patronCategory.name");
				}
			}
		}
		
		if (obj.getMaximumCheckOutPeriod()==null){
			errors.rejectValue("maximumCheckOutPeriod", "required.patronCategory.maximumCheckOutPeriod");
		} else {
			if (obj.getMaximumCheckOutPeriod().longValue()<0){
				errors.rejectValue("maximumCheckOutPeriod", "value.patronCategory.maximumCheckOutPeriod");
			}
		}
		
		if (obj.getMaximumCheckOuts()==null){
			errors.rejectValue("maximumCheckOuts", "required.patronCategory.maximumCheckOuts");
		} else {
			if (obj.getMaximumCheckOuts().longValue()<0){
				errors.rejectValue("maximumCheckOuts", "value.patronCategory.maximumCheckOuts");
			}
		}

		if (obj.getMaximumHoldPeriod()==null){
			errors.rejectValue("maximumHoldPeriod", "required.patronCategory.maximumHoldPeriod");
		} else {
			if (obj.getMaximumHoldPeriod().longValue()<0){
				errors.rejectValue("maximumHoldPeriod", "value.patronCategory.maximumHoldPeriod");
			}
		}

		if (obj.getMaximumHolds()==null){
			errors.rejectValue("maximumHolds", "required.patronCategory.maximumHolds");
		} else {
			if (obj.getMaximumHolds().longValue()<0){
				errors.rejectValue("maximumHolds", "value.patronCategory.maximumHolds");
			}
		}

		if (obj.getMaximumReservePeriod()==null){
			errors.rejectValue("maximumReservePeriod", "required.patronCategory.maximumReservePeriod");
		} else {
			if (obj.getMaximumReservePeriod().longValue()<0){
				errors.rejectValue("maximumReservePeriod", "value.patronCategory.maximumReservePeriod");
			}
		}

		if (obj.getMaximumReserves()==null){
			errors.rejectValue("maximumReserves", "required.patronCategory.maximumReserves");
		} else {
			if (obj.getMaximumReserves().longValue()<0){
				errors.rejectValue("maximumReserves", "value.patronCategory.maximumReserves");
			}
		}
	}
}
