package org.sur.domino.service.rest;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.sur.domino.model.DominoRequest;
import org.sur.domino.model.DominoResponse;
import org.sur.domino.model.exception.DominoException;
import org.sur.domino.service.types.DominoService;

@RestController
@RequestMapping("/api")
public class DominoRestController {
	private static final Logger logger = LoggerFactory.getLogger(DominoRestController.class);
	
	@Autowired
	private DominoService dominoService;
	
	@PostMapping("/dominoHighestValue")
	public DominoResponse getDominoHighestValue(
		@Valid	@RequestBody DominoRequest dominoRequest
			) throws DominoException {
		logger.info("getDominoHighestValue: Begin");
		DominoResponse dominoResponse = null;
		try {
			logger.info("dominoRequest = " + dominoRequest);
			dominoResponse = dominoService.getHighestValueDominoChain(
					dominoRequest.getInitialDominoItem(), 
					dominoRequest.getDominoItems());
			logger.info("dominoResponse = " + dominoResponse);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new DominoException(e);
		} 
		
		return dominoResponse;
	}

}