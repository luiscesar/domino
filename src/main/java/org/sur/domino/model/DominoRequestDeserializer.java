package org.sur.domino.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sur.domino.model.exception.InvalidValueException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class DominoRequestDeserializer extends JsonDeserializer<DominoRequest> {

	private static Logger logger = LoggerFactory.getLogger(DominoRequestDeserializer.class);
	
	public DominoRequest deserialize(JsonParser p, 
			DeserializationContext ctxt) 
			throws IOException, JacksonException {
		logger.info("deserialize: Begin");
		DominoRequest dominoRequest;
		DominoItem initialDominoItem;
		List<DominoItem> dominoItems;
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = p.getCodec().readTree(p);
			mapper.disable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
			String initialDominoItemJson = "" + node.get("initialDominoItem");
			initialDominoItem = mapper.readValue(initialDominoItemJson, DominoItem.class);
			
			Iterator<JsonNode> iterator = node.get("dominoItems").elements();
			dominoItems = new ArrayList<DominoItem>();
			while (iterator.hasNext()) {
				JsonNode jsonNode = iterator.next();
				String dominoItemJson = "" + jsonNode;
				DominoItem dominoItem = mapper.readValue(dominoItemJson, DominoItem.class);
				dominoItems.add(dominoItem);			
			}
			dominoRequest = new DominoRequest(initialDominoItem, dominoItems);	
		} catch (RuntimeException e) {
			logger.error("e: "+ e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (InvalidFormatException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			InvalidValueException exception = 
					new InvalidValueException("DominoItem values must be integers");
			throw exception;
		}
			
		return dominoRequest;
	}

}
