package com.custom.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	List<String> zipcodes;
	
	public void initialize(ZipCode constraintAnnotation) {
		zipcodes = new ArrayList<String>();
		System.out.println("ZipCode Validator Initialize");
		switch (constraintAnnotation.country())	 {
		case US:
			zipcodes.add("90001");
			zipcodes.add("90002");
			zipcodes.add("90003");
			break;
			
		case GERMANY:
			zipcodes.add("AB10");
			zipcodes.add("C1H");
			zipcodes.add("8IO0P");
			break;
			
		case UK:
			zipcodes.add("70001");
			zipcodes.add("70002");
			zipcodes.add("70003");
			break;
			
		case CANADA:
			zipcodes.add("600011");
			zipcodes.add("600022");
			zipcodes.add("600033");
			break;
			
		}
		
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Validating value "+value);
		System.out.println("state "+zipcodes.contains(value));
		return zipcodes.contains(value);
	}

}
