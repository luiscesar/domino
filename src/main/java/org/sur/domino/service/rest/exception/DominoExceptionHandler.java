package org.sur.domino.service.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sur.domino.model.exception.DominoError;
import org.sur.domino.model.exception.DominoException;

@ControllerAdvice
public class DominoExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(InvalidValuetExceptionHandler.class);

	@ExceptionHandler(value = DominoException.class)
	ResponseEntity<DominoError> exception(DominoException exception) {
		logger.info("exception");
		DominoError dominoErrorEntity = 
				new DominoError(exception.getMessage());
		return new ResponseEntity<DominoError>(
				dominoErrorEntity, 
				HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
}

