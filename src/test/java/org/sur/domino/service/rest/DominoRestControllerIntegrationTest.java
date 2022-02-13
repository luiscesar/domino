package org.sur.domino.service.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sur.domino.application.DominoAppConfiguration;
import org.sur.domino.application.DominoApplication;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DominoRestControllerIntegrationTest {
	
	private static Logger logger = 
			LoggerFactory.getLogger(DominoRestControllerIntegrationTest.class);

	private static ConfigurableApplicationContext ctx = null;

	@BeforeAll
	public static void initContext() {
		ctx = new AnnotationConfigApplicationContext(DominoApplication.class);
	}
	
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
	
}
