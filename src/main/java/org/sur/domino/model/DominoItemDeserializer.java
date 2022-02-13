package org.sur.domino.model;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.sur.domino.model.exception.InvalidValueException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class DominoItemDeserializer extends JsonDeserializer<DominoItem> {

	private static Logger logger = LoggerFactory.getLogger(DominoItemDeserializer.class);
	
	public DominoItem deserialize(JsonParser p, 
			DeserializationContext ctxt) 
			throws IOException, JacksonException {
		logger.info("deserialize: Begin");
		DominoItem dominoItem = null;
		String firstString, secondString;
		Integer first, second;
		try {
			JsonNode node = p.getCodec().readTree(p);
			try {
				firstString = node.get("first").asText();		
				first = Integer.parseInt(firstString);
			} catch (NumberFormatException e1) {
				String errorMessage = "first: " + e1.getMessage();
				logger.error(errorMessage);
				throw new InvalidValueException(errorMessage);
			}
			try {
				secondString = node.get("second").asText();
				second = Integer.parseInt(secondString);
			} catch (NumberFormatException e2) {
				String errorMessage = "first: " + e2.getMessage();
				logger.error(errorMessage);
				throw new InvalidValueException(errorMessage);
			}		
			dominoItem = new DominoItem(first, second);	

		} catch (RuntimeException e) {
			logger.error("e: "+ e.getMessage());
			throw e;
		}
			
		return dominoItem;
	}

}
