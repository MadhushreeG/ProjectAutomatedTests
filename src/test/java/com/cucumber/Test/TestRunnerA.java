/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package com.cucumber.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;

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
(features={"src/test/resources/Features/AlchemyMainScreenValidation.feature"},
glue={"com.cucumber.TestSteps"},
tags = {},
monochrome = true,
//dryRun = true,
plugin = { "html:Reporting/CucumberReports/CucumberReportRunnerA",
"com.cucumber.listener.ExtentCucumberFormatter:Reporting/CucumberReports/TestRunnerA.html"}
)

public class TestRunnerA extends AbstractTestNGCucumberTests {
	
	private static Logger logger = LoggerFactory.getLogger(TestRunnerA.class);
	
	@BeforeClass @Parameters ({"BrowserName"})
	public static void InitializeTest( String BrowserName) throws InvocationTargetException, IllegalAccessException{
		
		
		logger.info("Inside RunnerA class");
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
	    			SetExtentReportContent();
	    	}catch(Exception e) {
	    		
	    		logger.error("An error occured quitting driver. Check the logs below");
	    		logger.error(e.getMessage().toString());
	    	}
	    }
	
	    private void SetExtentReportContent() throws UnknownHostException {
	    	Reporter.loadXMLConfig(new File("src/main/resources/propertyFiles/extent-config.xml"));
	    	Reporter.assignAuthor("Deepak_Tiwari");
		    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Selenium", "3.9.1");
		    Reporter.setSystemInfo("Maven", "3.5.2");
		    Reporter.setSystemInfo("Java Version", "1.8.0_161");
		    
	    }
	
}
