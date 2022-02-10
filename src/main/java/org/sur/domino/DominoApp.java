package org.sur.domino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DominoApp {
	static Logger logger = LoggerFactory.getLogger(DominoApp.class);
	
	public static void main(String[] args) {
		logger.info("main: Begin");
		SpringApplication.run(DominoApp.class, args);    
	}
}
