package com.jaworskimateusz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldConfirmValidator implements ConstraintValidator<FieldConfirm, Object> {

	private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final FieldConfirm constraintAnnotation) {
	    firstFieldName = constraintAnnotation.password();
	    secondFieldName = constraintAnnotation.confirmedPassword();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        boolean valid = true;
        try {
            final Object firstObject = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
            final Object secondObject = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
            valid =  firstObject == null && secondObject == null || firstObject != null && firstObject.equals(secondObject);
        }
        catch(final Exception e) {
           e.printStackTrace();
        }

        if (!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}
