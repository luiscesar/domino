package org.sur.domino.service.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sur.domino.model.exception.DominoException;

@ControllerAdvice
public class DominoExceptionHandler {

	@ExceptionHandler(value = DominoException.class)
	ResponseEntity<Object> exception(DominoException exception) {
		return new ResponseEntity<>(
				exception.getMessage(), 
				HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
}

