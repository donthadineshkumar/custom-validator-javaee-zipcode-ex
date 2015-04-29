package com.custom.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Documented
@Target({ElementType.ANNOTATION_TYPE,
	ElementType.METHOD,
	ElementType.FIELD,
	ElementType.CONSTRUCTOR,
	ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ZipCodeValidator.class)
@Size(min=5, message="{zipcode_minsize}")
@Pattern(regexp="[0-9]*")
@NotNull(message="{zipcode_notnull}")
public @interface ZipCode {

	String message() default "{zipcode_invalid}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	Country country() default Country.US;
	
	public enum Country {
		US,
		GERMANY,
		UK,
		CANADA
	}
	
}
