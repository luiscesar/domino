package org.sur.domino.service.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sur.domino.model.exception.DominoErrorEntity;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class InvalidFormatExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(InvalidFormatExceptionHandler.class);
	
	@ExceptionHandler(value = InvalidFormatException.class)
	ResponseEntity<DominoErrorEntity> exception(InvalidFormatException exception) {
		logger.info("exception");
		DominoErrorEntity dominoErrorEntity = 
				new DominoErrorEntity("Float cannot be converted to Integer");
		return new ResponseEntity<DominoErrorEntity>(
				dominoErrorEntity, 
				HttpStatus.BAD_REQUEST);	
	}
}
