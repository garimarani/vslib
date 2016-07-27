package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.VslibParams;

@Component
public class ParametersContactValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return VslibParams.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		VslibParams obj = (VslibParams) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationName", "required.vslibParams.organizationName");
		
		if (obj.getOrganizationName()!=null){
			if (!this.lengthRange(obj.getOrganizationName(), 1, 255)){
				errors.rejectValue("organizationName", "size.vslibParams.organizationName");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organizationAddress", "required.vslibParams.organizationAddress");
		
		if (obj.getOrganizationAddress()!=null){
			if (!this.lengthRange(obj.getOrganizationAddress(), 1, 255)){
				errors.rejectValue("organizationAddress", "size.vslibParams.organizationAddress");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactName", "required.vslibParams.contactName");
		
		if (obj.getContactName()!=null){
			if (!this.lengthRange(obj.getContactName(), 1, 255)){
				errors.rejectValue("contactName", "size.vslibParams.contactName");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactAddress", "required.vslibParams.contactAddress");
		
		if (obj.getContactAddress()!=null){
			if (!this.lengthRange(obj.getContactAddress(), 1, 255)){
				errors.rejectValue("contactAddress", "size.vslibParams.contactAddress");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "siteUrl", "required.vslibParams.siteUrl");
		
		if (obj.getSiteUrl()!=null){
			if (!this.lengthRange(obj.getSiteUrl(), 1, 255)){
				errors.rejectValue("siteUrl", "size.vslibParams.siteUrl");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactEmail", "required.vslibParams.contactEmail");
		
		if (obj.getContactEmail()!=null){
			if (!this.lengthRange(obj.getContactEmail(), 1, 255)){
				errors.rejectValue("contactEmail", "size.vslibParams.contactEmail");
			}
		}
	}

}
