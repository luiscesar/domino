package org.sur.domino.service.rest;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import org.sur.domino.model.DominoRequest;
import org.sur.domino.model.DominoResponse;
import org.sur.domino.model.exception.DominoException;
import org.sur.domino.service.types.DominoService;

@RestController
@RequestMapping("/api")
public class DominoRestController {
	private static final Logger log = LoggerFactory.getLogger(DominoRestController.class);
	
	@Autowired
	private DominoService dominoService;
	
	@GetMapping("/dominoHighestValue")
	public DominoResponse getDominoHighestValue(
		@Valid	@RequestBody DominoRequest dominoRequest
			) throws DominoException {
		log.info("getDominoHighestValue: Begin");
		DominoResponse dominoResponse = null;
		try {
			log.info("dominoRequest = " + dominoRequest);
			dominoResponse = dominoService.getHighestValueDominoChain(
					dominoRequest.getInitialDominoItem(), 
					dominoRequest.getDominoItems());
			log.info("dominoResponse = " + dominoResponse);
		} catch (RuntimeException e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw new DominoException(e);
		} 
		
		return dominoResponse;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}

