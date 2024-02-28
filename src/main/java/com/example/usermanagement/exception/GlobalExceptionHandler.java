package com.example.usermanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex){
		return 
				new ResponseEntity<String>("Resource not found : "+ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserUnProcessabilityException.class)
	public ResponseEntity<String> handleUserUnProcessabilityException(UserUnProcessabilityException ex){
		return 
				new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException ex){
		return 
				new ResponseEntity<String>(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
	}
}
