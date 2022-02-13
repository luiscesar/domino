package org.sur.domino.service.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sur.domino.model.exception.InvalidValueException;

@ControllerAdvice
public class InvalidValueExceptionHandler {

	@ExceptionHandler(value = InvalidValueException.class)
	ResponseEntity<Object> exception(InvalidValueException exception) {
		return new ResponseEntity<>(
				exception.getMessage(), 
				HttpStatus.BAD_REQUEST);	
	}
}
