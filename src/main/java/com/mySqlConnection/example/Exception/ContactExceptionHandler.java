package com.mySqlConnection.example.Exception;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ContactExceptionHandler extends RuntimeException{

	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException exception, WebRequest request){
		
		ErrorDetails details=new ErrorDetails(new Date(),exception.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(details,HttpStatus.NOT_FOUND);
		
	}
	
	//@ExceptionHandler(ArithmeticException.class)
}

