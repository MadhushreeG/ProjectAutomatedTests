/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package com.cucumber.Test;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import frameworkcore.webdriverFactory.DriverManager;


@CucumberOptions
(features={"src/test/resources/Features/cucumbertest2.feature"},
glue={"com.cucumber.TestSteps"},
tags = {},
//dryRun = true,
plugin = { "html:Reporting/CucumberReports/CucumberReportRunnerB",
		"com.cucumber.listener.ExtentCucumberFormatter:Reporting/CucumberReports/TestRunnerB.html"}
)


	public class TestRunnerB extends AbstractTestNGCucumberTests {
	
	private static Logger logger = LoggerFactory.getLogger(TestRunnerB.class);
	
	@BeforeClass @Parameters ({"BrowserName"})
	public static void InitializeTest( String BrowserName) throws InvocationTargetException, IllegalAccessException{
		
		logger.info("Inside RunnerB class");
		
		try{
			
			DriverManager.setDriver(BrowserName);
			
			}catch(Exception e){
				logger.error("not able to initialize Webdriver. Please check the logs");
				logger.error(e.toString());
			}
	}

	    @AfterClass
	    public void afterMethod() {
	    	try {
	    		DriverManager.quitDriver();
	    		Reporter.getExtentReport().flush();
	    	}catch(Exception e) {
	    		
	    		logger.error("An error occured quitting driver. Check the logs below");
	    		logger.error(e.getMessage().toString());
	    	}
	    }
	
	
}
