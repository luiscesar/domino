package org.sur.domino.service.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sur.domino.model.DominoItem;
import org.sur.domino.model.DominoRequest;
import org.sur.domino.model.DominoResponse;
import org.sur.domino.model.exception.DominoException;
import org.sur.domino.service.types.DominoService;

@ExtendWith(MockitoExtension.class)
public class DominoRestControllerTest {

	private static Logger logger = LoggerFactory.getLogger(DominoRestControllerTest.class);
	
	@InjectMocks
	private DominoRestController dominoRestController = new DominoRestController();
	
	@Mock
	private DominoService dominoService;
	
	@BeforeAll
	static public void initContext() {
		logger.info("initContext: Begin");
	}
	
	@BeforeEach
	public void beforeTest() {
		logger.info("beforeTest: Begin");
	}
	
	@AfterEach
	public void afterTest() {
		logger.info("afterTest: Begin");
	}
	
	@Test
	public void test001Case1() {
		logger.info("test001Case1: Begin");
		DominoRequest dominoRequest;
		DominoResponse expectedDominoResponse;
		DominoResponse computedDominoResponse;
		try {
			dominoRequest = getDominoRequestCase1();
			expectedDominoResponse = getDominoResponseCase1();
			assertTrue(dominoService != null);
			Mockito.when(dominoService.getHighestValueDominoChain(
					dominoRequest.getInitialDominoItem(),
					dominoRequest.getDominoItems()))
				.thenReturn(expectedDominoResponse);
			assertTrue(dominoRestController != null);
			computedDominoResponse = 
					dominoService.getHighestValueDominoChain(
							dominoRequest.getInitialDominoItem(),
							dominoRequest.getDominoItems());
			assertTrue(expectedDominoResponse.equals(computedDominoResponse));
		} catch (RuntimeException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (DominoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
	}

	@Test
	public void test001Case2() {
		logger.info("test001Case2: Begin");
		try {
			assertTrue(dominoRestController != null);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
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
	
	private DominoResponse getDominoResponseCase1() {
		DominoResponse dominoResponse = new DominoResponse();
		
		return dominoResponse;
	}
}
