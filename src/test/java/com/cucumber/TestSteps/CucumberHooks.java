/**
 * This project is using Spring 
 */
package com.cucumber.TestSteps;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import frameworkcore.ReportingClass.Reporting;
import frameworkcore.webdriverFactory.DriverManager;

import com.cucumber.Test.TestRunnerA;
import com.cucumber.listener.Reporter;
/**
 * @author dtiwa1
 *
 */
public class CucumberHooks {
	
	private static Logger logger = LoggerFactory.getLogger(CucumberHooks.class);
	
	@Before("@Feature")
	public void BeforeStartOfFeature() {
		logger.info("Before Start running Feature ");
	}
	
	@Before
	public void BeforeStartOfScenarioHook(Scenario scenario) throws ClassNotFoundException {
		 logger.info("Inside Hooks Before. Before Running Scenario " + scenario.getName());
	}
		
	@After
	public void AfterEndOfScenarioHook(Scenario scenario) throws IOException{
		logger.info("Inside Hooks After. After Running Scenario, Scenario status is " + scenario.getStatus());
		//Reporter.addScreenCaptureFromPath(Reporting.CaptureScreenShot(DriverManager.getDriver()));
		//Reporting.FlushReport();
	}
	
		
	@After("@Feature")
	public void AfterEndOfFeature(){
		logger.info("After End running Feature");
	}

}
