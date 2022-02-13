package org.sur.domino.application;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DominoApplication.class })
public class DominoApplicationIntegrationTest {

	private static Logger logger = LoggerFactory.getLogger(DominoApplicationIntegrationTest.class);
	
	@Test
	public void test001Case1() {
		logger.info("test001Case1: Begin");
		try {
			
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void test001Case2() {
		logger.info("test001Case2: Begin");
		try {
			
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
}
