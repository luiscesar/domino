package org.sur.domino.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.sur.domino.application.DominoAppConfiguration;
import org.sur.domino.application.DominoApplication;
import org.sur.domino.service.types.DominoService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The type Domino rest controller integration test.
 */
@SpringBootTest
@ContextConfiguration(classes = {DominoApplication.class })
public class DominoRestControllerIntegrationTest {
	
	private static Logger logger = 
			LoggerFactory.getLogger(DominoRestControllerIntegrationTest.class);

	// Configurable Application Context
	private static ConfigurableApplicationContext ctx = null;

	@Autowired
	private DominoService dominoService;

	/**
	 * Init context.
	 */
	@BeforeAll
	public static void initContext() {
		ctx = new AnnotationConfigApplicationContext(DominoApplication.class);
	}

	/**
	 * Test 001 case 1.
	 */
	@Test
	public void test001Case1() {
		logger.info("test001Case1: Begin");
		DominoRestController dominoRestController;
		try {
			dominoRestController = ctx.getBean(DominoRestController.class);
			assertTrue(dominoRestController != null);
			logger.info("dominoRestController = " + dominoRestController);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test 001 case 2.
	 */
	@Test
	public void test001Case2() {
		logger.info("test001Case2: Begin");
		DominoRestController dominoRestController;
		try {
			assertTrue(dominoService != null);
			logger.info("dominoService = " + dominoService);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
}
