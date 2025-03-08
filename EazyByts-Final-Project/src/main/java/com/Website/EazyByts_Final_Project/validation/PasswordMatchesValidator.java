package com.Website.EazyByts_Final_Project.validation;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	private String field;
	private String fieldMatch;

	public void initialize(PasswordMatches constraintAnnotation) {
		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
	}

	public boolean isValid(Object value, ConstraintValidatorContext context) {

		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

		if (fieldValue != null) {
			boolean isValid = fieldValue.equals(fieldMatchValue);
			if (!isValid) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
						.addPropertyNode(fieldMatch)
						.addConstraintViolation();

				context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
						.addPropertyNode(field)
						.addConstraintViolation();
			}
			return isValid;
		} else {
			return fieldMatchValue == null;
		}
	}

}
