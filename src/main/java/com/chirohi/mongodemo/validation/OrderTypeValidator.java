package com.chirohi.mongodemo.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CustomFieldValidator.class)
public @interface OrderTypeValidator {
	
	public String message() default "Invalie OrderType: Should be !!!";
	
	Class<?> [] groups() default{};
	Class<? extends Payload>[] payload() default {};
	

}
