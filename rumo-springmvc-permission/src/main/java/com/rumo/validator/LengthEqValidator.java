package com.rumo.validator;
import  javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class LengthEqValidator implements ConstraintValidator<LengthEq, String> {

	private boolean required = false;
	private int length;
	
	public void initialize(LengthEq constraintAnnotation) {
		required = constraintAnnotation.required();
		length = constraintAnnotation.length();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(required) {
			return value.length() == length;
		}else {
			if(StringUtils.isEmpty(value)) {
				return true;
			}else {
				return value.length() == length;
			}
		}
	}
}
