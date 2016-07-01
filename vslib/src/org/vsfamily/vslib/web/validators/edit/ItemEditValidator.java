package org.vsfamily.vslib.web.validators.edit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Item;
import org.vsfamily.vslib.web.service.VslibService;

@Component
public class ItemEditValidator extends VslibBaseValidator implements Validator {

	@Autowired
	VslibService vslibService;
	
	@Override
	public boolean supports(Class<?> cls) {
		return Item.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Item obj = (Item) target;
		
		if (obj.getDocument()==null){
			errors.rejectValue("document", "required.item.document");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "barcodeNumber", "required.item.barcodeNumber");
		
		if (obj.getBarcodeNumber()!=null){
			if (!this.lengthRange(obj.getBarcodeNumber(), 1, 20)){
				errors.rejectValue("barcodeNumber", "size.item.barcodeNumber");
			} else {
				
				Item item = this.vslibService.getItemByNumber(obj.getBarcodeNumber());
				
				if (item!=null && !item.getId().equals(obj.getId())){
					errors.rejectValue("barcodeNumber", "unique.item.barcodeNumber");
				}
			}
		}
		
		if (obj.getClassNumber()!=null){
			if (!this.lengthRange(obj.getClassNumber(), 0, 100)){
				errors.rejectValue("classNumber", "size.item.classNumber");
			}
		}
		
		if (obj.getItemType()==null){
			errors.rejectValue("itemType", "required.item.itemType");
		}
		
		if (obj.getLibraryBranch()==null){
			errors.rejectValue("libraryBranch", "required.item.libraryBranch");
		}
		
		if (obj.getSubject()==null){
			errors.rejectValue("subject", "required.item.subject");
		}
		
		if (obj.getLanguage()==null){
			errors.rejectValue("language", "required.item.language");
		}
	}
}
