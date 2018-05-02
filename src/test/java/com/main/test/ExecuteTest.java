package com.main.test;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import corepackage.RunWithTestNG;
import frameworkcore.excelReader.InputDataReaderImpl;

public class ExecuteTest {
	
	private static Logger logger = LoggerFactory.getLogger(ExecuteTest.class);
	static String log4jConfPath = "src/main/resources/propertyFiles/Log4j.properties";
	
	@Test
	public void StartTestExecution() throws IOException {

		RunWithTestNG.ExecuteTests();
		
	}
	
	
	@Before
	public void Initialize() throws IOException {
		PropertyConfigurator.configure(log4jConfPath);
		logger.info("Logging started");
		InputDataReaderImpl.ReadExcelInputData();
	}
	
	@After
	public void TearDown() {
		logger.info("Test Execution Complete");
	}
	

}
