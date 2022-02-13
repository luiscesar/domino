package org.sur.domino.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DominoApplication {
	static Logger logger = LoggerFactory.getLogger(DominoApplication.class);
	
	public static void main(String[] args) {
		logger.info("main: Begin");
		SpringApplication.run(DominoApplication.class, args);    
	}
}
