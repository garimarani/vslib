package org.vsfamily.vslib.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.vsfamily.vslib.common.VslibBaseValidator;

/**
 * Validator used while changing password.
 */
@Component
public class ChangePasswordValidator extends VslibBaseValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
