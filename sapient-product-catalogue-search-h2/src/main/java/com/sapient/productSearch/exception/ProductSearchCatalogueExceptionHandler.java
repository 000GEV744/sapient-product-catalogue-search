package com.sapient.productSearch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sapient.productSearch.model.ErrorResponse;

@ControllerAdvice
public class ProductSearchCatalogueExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException exc){
		ErrorResponse error = new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//adding another exception handler ... to catch any exception
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc){
	//create a studentErrorResponse
		ErrorResponse error = new ErrorResponse();
	error.setMessage(exc.getMessage());
	error.setTimestamp(System.currentTimeMillis());
	error.setStatus(HttpStatus.BAD_REQUEST.value());
	//return ResponseEntity
	return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
}
