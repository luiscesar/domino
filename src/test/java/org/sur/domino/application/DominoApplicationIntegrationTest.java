package org.sur.domino.application;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.sur.domino.model.DominoItem;
import org.sur.domino.model.DominoRequest;
import org.sur.domino.model.DominoResponse;
import org.sur.domino.model.ValidDominoChain;
import org.sur.domino.model.exception.DominoError;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DominoApplicationIntegrationTest {

	private static Logger logger = LoggerFactory.getLogger(DominoApplicationIntegrationTest.class);
	
	@BeforeAll
	public static void beforeTest() {
		logger.info("beforeTest: Begin");
		String[] args = new String[0];
		ConfigurableApplicationContext ct = 
				SpringApplication.run(DominoApplication.class, args);
		logger.info("ct = " + ct);
	}
	
	@Test
	public void test001Case1() {
		logger.info("test001Case1: Begin");
		DominoRequest body = null;
    	String uri = null;
    	ResponseEntity<DominoResponse> response = null;
    	DominoResponse expectedResponse, computedResponse;
    	RestTemplate restTemplate = null;
		try {
			expectedResponse = getExpectedDominoResponseCase1();
			restTemplate = new RestTemplate();
			uri = "http://localhost:8080/api/dominoHighestValue";
			body = getDominoRequestCase1();
			HttpHeaders headers = new HttpHeaders();
    		headers.set("Content-Type", "application/json");
    		
    		HttpEntity<DominoRequest> requestEntity = new HttpEntity<DominoRequest>(body, headers);
    	    Map<String, String> params = new HashMap<String, String>();
    	    logger.info("Before calling service ...");
    		response = restTemplate.exchange(uri, HttpMethod.POST, 
    				requestEntity, DominoResponse.class, params);
    		logger.info("response = " + response);
    		computedResponse = response.getBody();
    		computedResponse.equals(expectedResponse);
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void test002ExceptionCase1() {
		logger.info("test002ExceptionCase1: Begin");
		String body = null;
    	String uri = null;
    	ResponseEntity<DominoResponse> response = null;  	
    	RestTemplate restTemplate = null;
    	DominoError expectedDominoError = null, computedDominoError = null;
		ObjectMapper mapper = null;
		try {
			mapper = new ObjectMapper();
			expectedDominoError = getExpectedDominoErrorExceptionCase1();
			restTemplate = new RestTemplate();
			uri = "http://localhost:8080/api/dominoHighestValue";
			body = getDominoRequestExceptionCase1();
			HttpHeaders headers = new HttpHeaders();
    		headers.set("Content-Type", "application/json");
    		
    		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
    	    Map<String, String> params = new HashMap<String, String>();
    	    logger.info("Before calling service ...");
    		response = restTemplate.exchange(uri, HttpMethod.POST, 
    				requestEntity, DominoResponse.class, params);
    		logger.info("response = " + response);
    		fail("HttpClientErrorException expected");
		} catch (HttpClientErrorException e) {
			logger.info(e.getMessage());
			String responseBody = e.getResponseBodyAsString();
			logger.info("responseBody = " + responseBody);
			try {
				computedDominoError = mapper.readValue(
						responseBody, DominoError.class);
				computedDominoError.equals(expectedDominoError);
			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
				fail(e1.getMessage());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	private DominoResponse getExpectedDominoResponseCase1() {
		DominoResponse dominoResponse = new DominoResponse();
		ValidDominoChain dominoChain = new ValidDominoChain();
		LinkedList<DominoItem> chain = new LinkedList<DominoItem>();
		chain = getDominoItemLinkedListCase1();
		Integer leftMost = 7;
		Integer rightMost = 2;
		Integer value = 9;
		dominoChain.setChain(chain);
		dominoChain.setLeftMost(leftMost);
		dominoChain.setRightMost(rightMost);
		dominoChain.setValue(value);
		return dominoResponse;
	}
	
	private DominoError getExpectedDominoErrorExceptionCase1() {
		DominoError dominoError = new DominoError("DominoItem values must be integers");
		return dominoError;
	}

	private DominoRequest getDominoRequestCase1() {
		DominoRequest dominoRequest = new DominoRequest();
		DominoItem initialDominoItem = 
				this.getInitialDominoItemCase1();
		List<DominoItem> dominoItemList = 
				this.getDominoItemListCase1();
		dominoRequest.setInitialDominoItem(initialDominoItem);
		dominoRequest.setDominoItems(dominoItemList);
		return dominoRequest;
	}
	
	private LinkedList<DominoItem> getDominoItemLinkedListCase1() {
		LinkedList<DominoItem> dominoItemList = new LinkedList<DominoItem>();

		dominoItemList.add(new DominoItem(7,1));
		dominoItemList.add(new DominoItem(1,5));
		dominoItemList.add(new DominoItem(5,3));
		dominoItemList.add(new DominoItem(3,2));

		return dominoItemList;
	}
	private List<DominoItem> getDominoItemListCase1() {
		List<DominoItem> dominoItemList = new ArrayList<DominoItem>();

		dominoItemList.add(new DominoItem(7,1));
		dominoItemList.add(new DominoItem(1,5));
		dominoItemList.add(new DominoItem(5,3));
		dominoItemList.add(new DominoItem(3,2));

		return dominoItemList;
	}

	private DominoItem getInitialDominoItemCase1() {
		DominoItem dominoItem = new DominoItem(7,1);
		return dominoItem;
	}
	
	private String getDominoRequestExceptionCase1() {
		String dominoRequest = null;
		dominoRequest = "{\"initialDominoItem\":{\"first\":1.1,\"second\":2},\"dominoItems\":[]}";
		
		return dominoRequest;
	}
	

}
