package com.cucumber.Test;

import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import frameworkcore.webdriverFactory.DriverManager;


@CucumberOptions
(features={"src/test/resources/Features/cucumbertest1.feature"},
glue={"com.cucumber.TestSteps"},
tags = {},
//dryRun = true,
//plugin = { "html:Reporting/CucumberReports/cucumber-html-reportA",
//        "json:Reporting/CucumberReports/cucumberA.json", "pretty:Reporting/CucumberReports/cucumber-prettyA.txt",
//        "usage:Reporting/CucumberReports/cucumber-usageA.json", "junit:Reporting/CucumberReports/cucumber-resultsA.xml" }
//)

//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reporting/CucumberReports/reportA.html"}
//)

plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
)

public class TestRunnerA extends AbstractTestNGCucumberTests {
	
	private static Logger logger = LoggerFactory.getLogger(TestRunnerA.class);
	
	@BeforeClass @Parameters ({"BrowserName"})
	public static void InitializeTest( String BrowserName) throws InvocationTargetException, IllegalAccessException{
		
		
		logger.info("Inside RunnerA class");
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("Reporting/CucumberReports/reportA.html");
		
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
	    	}catch(Exception e) {
	    		
	    		logger.error("An error occured quitting driver. Check the logs below");
	    		logger.error(e.getMessage().toString());
	    	}
	    }
	
	
}
