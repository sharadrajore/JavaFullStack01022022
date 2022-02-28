package com.zensar.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value = {PostIdNotAvailableException.class})
	public ResponseEntity<Object> handlePostIdError(RuntimeException exception,WebRequest request){
		System.out.println("I am inside GlobalExceptionHandler");
		return handleExceptionInternal(exception,exception.toString() , new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
