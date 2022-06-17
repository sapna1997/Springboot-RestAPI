package com.mySqlConnection.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiAllMethodsApplication {
	
	 private static final Logger logger = LoggerFactory.getLogger(RestApiAllMethodsApplication.class);


	public static void main(String[] args) {
		
		  logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	      Logger log=LoggerFactory.getLogger(RestApiAllMethodsApplication.class);
	      
		SpringApplication.run(RestApiAllMethodsApplication.class, args);
	}
	
	public void run(ApplicationArguments arg0) throws Exception {
	      System.out.println("Hello World from Application Runner");
	   }
	 

}
