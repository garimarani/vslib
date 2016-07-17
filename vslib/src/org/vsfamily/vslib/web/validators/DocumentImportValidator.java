package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.web.setup.forms.ItemDataUploadForm;

@Component
public class DocumentImportValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return ItemDataUploadForm.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ItemDataUploadForm obj = (ItemDataUploadForm) target;
		
		if (obj.getFile()==null){
			errors.rejectValue("file", "required.iduf.file");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uniformTitle", "required.iduf.uniformTitle");
		if (obj.getUniformTitle()==null){
			errors.rejectValue("uniformTitle", "required.iduf.uniformTitle");
		} else {
			if (obj.getUniformTitle()<1){
				errors.rejectValue("uniformTitle", "value.iduf.uniformTitle");
			}
		}
				
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryAuthor", "required.iduf.primaryAuthor");
		if (obj.getPrimaryAuthor()==null){
			errors.rejectValue("primaryAuthor", "required.iduf.primaryAuthor");
		} else {
			if (obj.getPrimaryAuthor()<1){
				errors.rejectValue("primaryAuthor", "value.iduf.primaryAuthor");
			}
		}
		
		if (obj.getSecondaryAuthors()==null){
			obj.setSecondaryAuthors(new Long(0));
		} else {
			if (obj.getSecondaryAuthors()<0){
				obj.setSecondaryAuthors(new Long(0));
			}
		}
		
		if (obj.getIsbn()==null){
			obj.setIsbn(new Long(0));
		} else {
			if (obj.getIsbn()<0){
				obj.setIsbn(new Long(0));
			}
		}
		
		if (obj.getEdition()==null){
			obj.setEdition(new Long(0));
		} else {
			if (obj.getEdition()<0){
				obj.setEdition(new Long(0));
			}
		}
		
		if (obj.getPublicationYear()==null){
			obj.setPublicationYear(new Long(0));
		} else {
			if (obj.getPublicationYear()<0){
				obj.setPublicationYear(new Long(0));
			}
		}
		
		if (obj.getCoverPrice()==null){
			obj.setCoverPrice(new Long(0));
		} else {
			if (obj.getCoverPrice()<0){
				obj.setCoverPrice(new Long(0));
			}
		}
		
		if (obj.getPublisher()==null){
			obj.setPublisher(new Long(0));
		} else {
			if (obj.getPublisher()<0){
				obj.setPublisher(new Long(0));
			}
		}
		
		if (obj.getSeriesStatement()==null){
			obj.setSeriesStatement(new Long(0));
		} else {
			if (obj.getSeriesStatement()<0){
				obj.setSeriesStatement(new Long(0));
			}
		}
		
		if (obj.getCopyright()==null){
			obj.setCopyright(new Long(0));
		} else {
			if (obj.getCopyright()<0){
				obj.setCopyright(new Long(0));
			}
		}
		
		if (obj.getSummary()==null){
			obj.setSummary(new Long(0));
		} else {
			if (obj.getSummary()<0){
				obj.setSummary(new Long(0));
			}
		}
		
		if (obj.getKeywords()==null){
			obj.setKeywords(new Long(0));
		} else {
			if (obj.getKeywords()<0){
				obj.setKeywords(new Long(0));
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "barcodeNumber", "required.iduf.barcodeNumber");
		
		if (obj.getBarcodeNumber()==null){
			errors.rejectValue("barcodeNumber", "required.iduf.barcodeNumber");
		} else {
			if (obj.getBarcodeNumber()<1){
				errors.rejectValue("barcodeNumber", "value.iduf.barcodeNumber");
			}
		}
		
		if (obj.getClassNumber()==null){
			obj.setClassNumber(new Long(0));
		} else {
			if (obj.getClassNumber()<0){
				obj.setClassNumber(new Long(0));
			}
		}
		
		if (obj.getItemType()==null){
			obj.setItemType(new Long(0));
		} else {
			if (obj.getItemType()<0){
				obj.setItemType(new Long(0));
			}
		}
		
		if (obj.getLibraryBranch()==null){
			obj.setLibraryBranch(new Long(0));
		} else {
			if (obj.getLibraryBranch()<0){
				obj.setLibraryBranch(new Long(0));
			}
		}
		
		if (obj.getSubject()==null){
			obj.setSubject(new Long(0));
		} else {
			if (obj.getSubject()<0){
				obj.setSubject(new Long(0));
			}
		}
		
		if (obj.getLanguage()==null){
			obj.setLanguage(new Long(0));
		} else {
			if (obj.getLanguage()<0){
				obj.setLanguage(new Long(0));
			}
		}
		
		if (obj.getAlternateId()==null){
			obj.setAlternateId(new Long(0));
		} else {
			if (obj.getAlternateId()<0){
				obj.setAlternateId(new Long(0));
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fieldDelimiter",  "required.iduf.fieldDelimiter");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "textQualifier", "required.iduf.textQualifier");
	}
}
