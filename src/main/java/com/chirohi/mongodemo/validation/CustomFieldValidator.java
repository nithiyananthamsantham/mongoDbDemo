package com.chirohi.mongodemo.validation;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomFieldValidator implements ConstraintValidator<OrderTypeValidator, String>{

	@Override
	public boolean isValid(String orderType, ConstraintValidatorContext context) {
		
		List<String> orderTypeList = Arrays.asList("Electronics","Stationary");
		return orderTypeList.contains(orderType);
	}

	
}
