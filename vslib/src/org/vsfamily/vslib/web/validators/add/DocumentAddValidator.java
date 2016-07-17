package org.vsfamily.vslib.web.validators.add;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;
import org.vsfamily.vslib.common.domain.Document;

/**
 * Validator used for validating Document object at the time of addition.
 */
@Component
public class DocumentAddValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Document.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Document obj = (Document) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uniformTitle", "required.document.uniformTitle");
		
		if (obj.getUniformTitle()!=null){
			if (!this.lengthRange(obj.getUniformTitle(), 1, 2000)){
				errors.rejectValue("uniformTitle", "size.document.uniformTitle");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "primaryAuthor", "required.document.primaryAuthor");
		
		if (obj.getPrimaryAuthor()!=null){
			if (!this.lengthRange(obj.getPrimaryAuthor(), 1, 2000)){
				errors.rejectValue("primaryAuthor", "size.document.primaryAuthor");
			}
		}
		
		if (obj.getIsbn()!=null){
			if (!this.lengthRange(obj.getIsbn(), 0, 20)){
				errors.rejectValue("isbn", "size.document.isbn");
			}
		}
		
		if (obj.getEdition()!=null){
			if (!this.lengthRange(obj.getEdition(), 0, 100)){
				errors.rejectValue("edition", "size.document.edition");
			}
		}

		if (obj.getPublicationYear()!=null){
			if (!this.lengthRange(obj.getPublicationYear(), 0, 20)){
				errors.rejectValue("publicationYear", "size.document.publicationYear");
			}
		}

		if (obj.getCoverPrice()!=null){
			if (!this.lengthRange(obj.getCoverPrice(), 0, 20)){
				errors.rejectValue("coverPrice", "size.document.coverPrice");
			}
		}

		if (obj.getPublisher()!=null){
			if (!this.lengthRange(obj.getPublisher(), 0, 500)){
				errors.rejectValue("publisher", "size.document.publisher");
			}
		}

		if (obj.getSeriesStatement()!=null){
			if (!this.lengthRange(obj.getSeriesStatement(), 0, 2000)){
				errors.rejectValue("seriesStatement", "size.document.seriesStatement");
			}
		}

		if (obj.getCopyright()!=null){
			if (!this.lengthRange(obj.getCopyright(), 0, 2000)){
				errors.rejectValue("copyright", "size.document.copyright");
			}
		}
	}

}
