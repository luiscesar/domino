package org.sur.domino.service.rest.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sur.domino.model.exception.DominoErrorEntity;
import org.sur.domino.model.exception.DominoException;

@ControllerAdvice
public class DominoExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(InvalidFormatExceptionHandler.class);

	@ExceptionHandler(value = DominoException.class)
	ResponseEntity<DominoErrorEntity> exception(DominoException exception) {
		logger.info("exception");
		DominoErrorEntity dominoErrorEntity = 
				new DominoErrorEntity(exception.getMessage());
		return new ResponseEntity<DominoErrorEntity>(
				dominoErrorEntity, 
				HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
}

