package com.chirohi.mongodemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {
	
//	@ExceptionHandler(UserNotFoundException.class)
//	public ProblemDetail handleUserNotFoundException(UserNotFoundException ex) {
//		
//		System.out.println("Advice called getArgumentNotValid ");
//		return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
//		
//	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
		
		System.out.println("Advice called getArgumentNotValid ");
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		Map<String, String> errorMap = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		System.out.println("Advice called getArgumentNotValid...! "+errorMap);
		
		return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
		
	}
	


}
