package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.VslibParams;

/**
 * Validator used for validating storage (locations on hard disks) related parameters.
 */
@Component
public class ParametersStorageValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return VslibParams.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		VslibParams obj = (VslibParams) target;
		
		if (obj.getPhotosFolder()!=null){
			if (!this.lengthRange(obj.getPhotosFolder(), 0, 255)){
				errors.rejectValue("photosFolder", "size.vslibParams.photosFolder");
			}
		}

		if (obj.getEdocsFolder()!=null){
			if (!this.lengthRange(obj.getEdocsFolder(), 0, 255)){
				errors.rejectValue("edocsFolder", "size.vslibParams.edocsFolder");
			}
		}

		if (obj.getWorksFolder()!=null){
			if (!this.lengthRange(obj.getWorksFolder(), 0, 255)){
				errors.rejectValue("worksFolder", "size.vslibParams.worksFolder");
			}
		}
	}

}
