package org.vsfamily.vslib.web.validators.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.ItemType;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class ItemTypeEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return ItemType.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ItemType obj = (ItemType) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.itemType.code");
		
		if (obj.getCode()!=null){
			if (!this.lengthRange(obj.getCode(), 1, 10)){
				errors.rejectValue("code", "size.itemType.code");
			} else {
				
				ItemType itemType = this.vslibService.getItemTypeByCode(obj.getCode());
				
				if (itemType!=null && !itemType.getId().equals(obj.getId())){
					errors.rejectValue("code", "unique.itemType.code");
				}
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.itemType.name");
		
		if (obj.getName()!=null){
			if (!this.lengthRange(obj.getName(), 1, 50)){
				errors.rejectValue("name", "size.itemType.name");
			} else {
				
				ItemType itemType = this.vslibService.getItemTypeByName(obj.getName());
				
				if (itemType!=null && !itemType.getId().equals(obj.getId())){
					errors.rejectValue("name", "unique.itemType.name");
				}
			}
		}
		
		if (obj.getMaximumCheckOutPeriod()==null){
			errors.rejectValue("maximumCheckOutPeriod", "required.itemType.maximumCheckOutPeriod");
		} else {
			if (obj.getMaximumCheckOutPeriod().longValue()<0){
				errors.rejectValue("maximumCheckOutPeriod", "value.itemType.maximumCheckOutPeriod");
			}
		}

		if (obj.getMaximumHoldPeriod()==null){
			errors.rejectValue("maximumHoldPeriod", "required.itemType.maximumHoldPeriod");
		} else {
			if (obj.getMaximumHoldPeriod().longValue()<0){
				errors.rejectValue("maximumHoldPeriod", "value.itemType.maximumHoldPeriod");
			}
		}

		if (obj.getMaximumReservePeriod()==null){
			errors.rejectValue("maximumReservePeriod", "required.itemType.maximumReservePeriod");
		} else {
			if (obj.getMaximumReservePeriod().longValue()<0){
				errors.rejectValue("maximumReservePeriod", "value.itemType.maximumReservePeriod");
			}
		}
	}
}
