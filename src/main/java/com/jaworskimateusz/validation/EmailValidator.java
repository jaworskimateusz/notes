package com.jaworskimateusz.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<VerifyEmail, String> {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return (email == null) ? false : Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
	}

}
