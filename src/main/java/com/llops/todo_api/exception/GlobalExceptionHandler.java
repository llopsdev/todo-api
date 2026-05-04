package com.llops.todo_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String>handlerFoundException(ResourceNotFoundException rnfe){
		return ResponseEntity.status(404).body(rnfe.getMessage());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String>handlerIllegalException(IllegalArgumentException iae){
		return ResponseEntity.status(400).body(iae.getMessage());
	}
}
 