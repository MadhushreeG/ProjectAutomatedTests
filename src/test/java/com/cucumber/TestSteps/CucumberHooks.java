/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package com.cucumber.TestSteps;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import frameworkcore.ReportingClass.Reporting;
import frameworkcore.webdriverFactory.DriverManager;

public class CucumberHooks {
	
	private static Logger logger = LoggerFactory.getLogger(CucumberHooks.class);
	String featureName="";
	
	@Before("@Feature")
	public void BeforeStartOfFeature(Scenario scenario) {
		String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
	    featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
		logger.info("Start running Feature ##########  " + 	featureName + "   ##########");
	}
	
	@Before
	public void BeforeStartOfScenarioHook(Scenario scenario) throws ClassNotFoundException {
		logger.info("Starting execution of Scenario ##########" + scenario.getName() + "   ##########");
	}
		
	@After
	public void AfterEndOfScenarioHook(Scenario scenario) throws IOException{
		if(scenario.isFailed())
			Reporter.addScreenCaptureFromPath(Reporting.CaptureScreenShot(DriverManager.getDriver()));
			
			logger.info("Scenario execution done, Scenario status is #####  " + scenario.getStatus() + "   #####");
			Reporter.getExtentReport().flush();
	}
	
		
	@After("@Feature")
	public void AfterEndOfFeature(){
		logger.info("End running Feature ##########  " + 	featureName + "   ##########");
	}

}
