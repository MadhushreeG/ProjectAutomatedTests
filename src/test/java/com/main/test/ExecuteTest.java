package com.main.test;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import corepackage.RunWithTestNG;

public class ExecuteTest {
	
	private static Logger logger = LoggerFactory.getLogger(ExecuteTest.class);
	static String log4jConfPath = "src/main/resources/propertyFiles/Log4j.properties";
	
	@Test
	public void StartTestExecution() {

		RunWithTestNG.ExecuteTests();
		
	}
	
	
	@Before
	public void Initialize() {
		PropertyConfigurator.configure(log4jConfPath);
		logger.info("Logger started");
	}
	
	@After
	public void TearDown() {
		logger.info("Test Execution Complete");
	}
	

}
